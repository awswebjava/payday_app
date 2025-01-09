package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class grabarcalpardesdejson extends GXProcedure
{
   public grabarcalpardesdejson( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( grabarcalpardesdejson.class ), "" );
   }

   public grabarcalpardesdejson( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( )
   {
      execute_int();
   }

   private void execute_int( )
   {
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV23Pgmname, httpContext.getMessage( "hola", "")) ;
      GXv_char1[0] = AV11json ;
      GXv_char2[0] = AV8error ;
      new web.json_desdearchivo(remoteHandle, context).execute( AV9fecha, httpContext.getMessage( "calculo_parametros_2", ""), GXv_char1, GXv_char2) ;
      grabarcalpardesdejson.this.AV11json = GXv_char1[0] ;
      grabarcalpardesdejson.this.AV8error = GXv_char2[0] ;
      if ( ! (GXutil.strcmp("", AV8error)==0) )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV23Pgmname, httpContext.getMessage( "error ", "")+GXutil.trim( AV8error)) ;
      }
      else
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV23Pgmname, httpContext.getMessage( "&sdt_cal_par_ini ", "")+GXutil.trim( GXutil.str( AV13sdt_cal_par_ini.size(), 9, 0))) ;
         AV13sdt_cal_par_ini.fromJSonString(AV11json, null);
         AV24GXV1 = 1 ;
         while ( AV24GXV1 <= AV13sdt_cal_par_ini.size() )
         {
            AV10item = (web.Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item)((web.Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item)AV13sdt_cal_par_ini.elementAt(-1+AV24GXV1));
            AV12operandos = GXutil.trim( AV10item.getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Idoperando()) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV23Pgmname, httpContext.getMessage( "&item.PaiCod ", "")+GXutil.trim( AV10item.getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Paicod())+httpContext.getMessage( " &operandos ", "")+GXutil.trim( AV12operandos)+httpContext.getMessage( " &item.idOperando.Trim() ", "")+GXutil.trim( AV10item.getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Idoperando())) ;
            AV25GXLvl14 = (byte)(0) ;
            /* Using cursor P01Z02 */
            pr_default.execute(0, new Object[] {AV10item.getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Paicod(), AV12operandos});
            while ( (pr_default.getStatus(0) != 101) )
            {
               A74idOperando = P01Z02_A74idOperando[0] ;
               A46PaiCod = P01Z02_A46PaiCod[0] ;
               AV25GXLvl14 = (byte)(1) ;
               AV15existe = true ;
               pr_default.readNext(0);
            }
            pr_default.close(0);
            if ( AV25GXLvl14 == 0 )
            {
               AV15existe = false ;
            }
            if ( ! AV15existe )
            {
               AV16conCorchetes = GXutil.strReplace( GXutil.trim( AV10item.getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Idoperando()), "{", "[") ;
               AV16conCorchetes = GXutil.strReplace( GXutil.trim( AV16conCorchetes), "}", "]") ;
               AV12operandos = AV16conCorchetes ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV23Pgmname, httpContext.getMessage( "&item.PaiCod ", "")+GXutil.trim( AV10item.getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Paicod())+httpContext.getMessage( " &operandos ", "")+GXutil.trim( AV12operandos)+httpContext.getMessage( " &item.idOperando.Trim() ", "")+GXutil.trim( AV10item.getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Idoperando())) ;
            }
            /*
               INSERT RECORD ON TABLE Calculo_parametros

            */
            A46PaiCod = (short)(GXutil.lval( AV10item.getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Paicod())) ;
            A74idOperando = AV12operandos ;
            AV14CalParId = AV10item.getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Id() ;
            A2098CalParId = AV14CalParId ;
            A2099CalParCampo = AV10item.getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Validation() ;
            if ( (GXutil.strcmp("", AV10item.getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Valid_list())==0) )
            {
               A2111CalParValLista = "" ;
            }
            else
            {
               AV18palabras = new GXSimpleCollection<String>(String.class, "internal", "", GxRegex.Split(AV10item.getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Valid_list(),"\\|")) ;
               AV19i = (short)(1) ;
               AV17sdt_ParValLista.clear();
               while ( AV19i <= AV18palabras.size() )
               {
                  AV20itemSdtParLista = (web.Sdtsdt_ParValLista_sdt_ParValListaItem)new web.Sdtsdt_ParValLista_sdt_ParValListaItem(remoteHandle, context);
                  AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Calpargrp( (byte)(DecimalUtil.decToDouble(AV10item.getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Group())) );
                  AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Valor( GXutil.trim( (String)AV18palabras.elementAt(-1+AV19i)) );
                  AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Descripcion( GXutil.trim( AV10item.getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Name())+"." );
                  if ( GXutil.strcmp(GXutil.trim( (String)AV18palabras.elementAt(-1+AV19i)), httpContext.getMessage( "mejor", "")) == 0 )
                  {
                     AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Detail( httpContext.getMessage( "Obtener el valor más alto dentro del rango establecido.", "") );
                     AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation( httpContext.getMessage( "Ejemplo: {c CAL032 semestre <b>mejor</b>}", "") );
                  }
                  else if ( GXutil.strcmp(GXutil.trim( (String)AV18palabras.elementAt(-1+AV19i)), httpContext.getMessage( "promedio", "")) == 0 )
                  {
                     AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Detail( httpContext.getMessage( "Obtener el promedio de los valores dentro del rango establecido.", "") );
                     AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation( httpContext.getMessage( "Ejemplo: {c CAL032 semestre <b>promedio</b>}", "") );
                  }
                  else if ( GXutil.strcmp(GXutil.trim( (String)AV18palabras.elementAt(-1+AV19i)), httpContext.getMessage( "S", "")) == 0 )
                  {
                     AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Detail( httpContext.getMessage( "Obtener la suma de los valores dentro del rango establecido.", "") );
                     AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation( httpContext.getMessage( "Ejemplo: {c CAL032 semestre <b>S</b>} o también es válida la siguiente expresión porque por omisión el tipo de cálculo es \"suma\": {c CAL032 semestre}", "") );
                  }
                  else if ( GXutil.strcmp(GXutil.trim( (String)AV18palabras.elementAt(-1+AV19i)), httpContext.getMessage( "C", "")) == 0 )
                  {
                     AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Detail( httpContext.getMessage( "Recuperar valor de cantidad.", "") );
                     AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation( httpContext.getMessage( "Ejemplo: {c REM001 <b>C</b>}", "") );
                  }
                  else if ( GXutil.strcmp(GXutil.trim( (String)AV18palabras.elementAt(-1+AV19i)), httpContext.getMessage( "T", "")) == 0 )
                  {
                     AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Detail( httpContext.getMessage( "Recuperar valor de importe.", "") );
                     AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation( httpContext.getMessage( "Ejemplo: {c REM001 <b>T</b>} o también es válida la siguiente expresión porque por omisión el tipo de devolución es \"total\": {c REM001} ", "") );
                  }
                  else if ( GXutil.strcmp(GXutil.trim( (String)AV18palabras.elementAt(-1+AV19i)), httpContext.getMessage( "semestre", "")) == 0 )
                  {
                     AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Detail( httpContext.getMessage( "Recorrer liquidaciones del semestre que abarca el periodo de la liquidación actual, incluyendo la liquidación actual.", "") );
                     AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation( httpContext.getMessage( "Ejemplo: {c REM064 <b>semestre</b>}", "") );
                  }
                  else if ( GXutil.strcmp(GXutil.trim( (String)AV18palabras.elementAt(-1+AV19i)), httpContext.getMessage( "acumulado", "")) == 0 )
                  {
                     AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Detail( httpContext.getMessage( "Recorrer liquidaciones desde enero, incluyendo la liquidación actual.", "") );
                     AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation( httpContext.getMessage( "Ejemplo: {c CAL054 <b>acumulado</b>}", "") );
                  }
                  else if ( GXutil.strcmp(GXutil.trim( (String)AV18palabras.elementAt(-1+AV19i)), httpContext.getMessage( "deMesesAnteriores", "")) == 0 )
                  {
                     AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Detail( httpContext.getMessage( "Recorrer liquidaciones desde enero hasta el periodo anterior de la liquidación actual.", "") );
                     AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation( httpContext.getMessage( "Ejemplo: {c CAL039 <b>deMesesAnteriores</b>}", "") );
                  }
                  else if ( GXutil.strcmp(GXutil.trim( (String)AV18palabras.elementAt(-1+AV19i)), httpContext.getMessage( "liquidacionesAnteriores", "")) == 0 )
                  {
                     AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Detail( httpContext.getMessage( "Recorrer liquidaciones desde enero hasta el periodo actual, excluyendo la liquidación actual.", "") );
                     AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation( httpContext.getMessage( "Ejemplo: {c DES012 <b>liquidacionesAnteriores</b>}", "") );
                  }
                  else if ( GXutil.strcmp(GXutil.trim( (String)AV18palabras.elementAt(-1+AV19i)), httpContext.getMessage( "mismoPeriodo", "")) == 0 )
                  {
                     AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Detail( httpContext.getMessage( "Recorrer liquidaciones del mismo periodo de la liquidación actual, incluyendo la liquidación actual.", "") );
                     AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation( httpContext.getMessage( "Ejemplo: {c CAL032 <b>mismoPeriodo</b>}", "") );
                  }
                  else if ( GXutil.strcmp(GXutil.trim( (String)AV18palabras.elementAt(-1+AV19i)), httpContext.getMessage( "anterioresDelPeriodo", "")) == 0 )
                  {
                     AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Detail( httpContext.getMessage( "Recorrer liquidaciones del mismo periodo de la liquidación actual, excluyendo la liquidación actual.", "") );
                     AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation( httpContext.getMessage( "Ejemplo: {c CAL039 <b>anterioresDelPeriodo</b>}", "") );
                  }
                  else if ( GXutil.strcmp(GXutil.trim( (String)AV18palabras.elementAt(-1+AV19i)), httpContext.getMessage( "tramoGanancias", "")) == 0 )
                  {
                     AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Detail( httpContext.getMessage( "Recorrer liquidaciones de periodos del mismo tramo de ganancias, incluyendo la liquidación actual.", "") );
                     AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation( httpContext.getMessage( "Ejemplo: {c CAL032 <b>tramoGanancias</b> promedio}", "") );
                  }
                  else if ( GXutil.strcmp(GXutil.trim( (String)AV18palabras.elementAt(-1+AV19i)), httpContext.getMessage( "remunerativos", "")) == 0 )
                  {
                     AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Detail( GXutil.trim( AV10item.getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Description())+httpContext.getMessage( " \"remunerativo\".", "") );
                     if ( GXutil.strcmp(A74idOperando, "{concepto}") == 0 )
                     {
                        AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation( httpContext.getMessage( "Ejemplo: {c <b>remunerativos</b> semestre}", "") );
                     }
                     else
                     {
                        AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation( httpContext.getMessage( "Ejemplo: {retroactivo OFI_A <b>remunerativos</b> 202402 primera_quincena}", "") );
                     }
                  }
                  else if ( GXutil.strcmp(GXutil.trim( (String)AV18palabras.elementAt(-1+AV19i)), httpContext.getMessage( "no_remunerativos", "")) == 0 )
                  {
                     AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Detail( GXutil.trim( AV10item.getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Description())+httpContext.getMessage( " \"no remunerativo\".", "") );
                     if ( GXutil.strcmp(A74idOperando, "{concepto}") == 0 )
                     {
                        AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation( httpContext.getMessage( "Ejemplo: {c <b>no_remunerativos</b> semestre}", "") );
                     }
                     else
                     {
                        AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation( httpContext.getMessage( "Ejemplo: {retroactivo OFI_A <b>no_remunerativos</b> 202402 primera_quincena}", "") );
                     }
                  }
                  else if ( GXutil.strcmp(GXutil.trim( (String)AV18palabras.elementAt(-1+AV19i)), httpContext.getMessage( "descuentos", "")) == 0 )
                  {
                     AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Detail( GXutil.trim( AV10item.getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Description())+httpContext.getMessage( " \"descuento\".", "") );
                     if ( GXutil.strcmp(A74idOperando, "{concepto}") == 0 )
                     {
                        AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation( httpContext.getMessage( "Ejemplo: {c <b>descuentos</b> semestre}", "") );
                     }
                     else
                     {
                        AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation( httpContext.getMessage( "Ejemplo: {retroactivo OFI_A <b>descuentos</b> 202402 primera_quincena}", "") );
                     }
                  }
                  else if ( GXutil.strcmp(GXutil.trim( (String)AV18palabras.elementAt(-1+AV19i)), httpContext.getMessage( "J", "")) == 0 )
                  {
                     AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Detail( httpContext.getMessage( "Clase de legajo \"Jornal\".", "") );
                     AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation( httpContext.getMessage( "Ejemplo: {clase <b>J</b>}", "") );
                  }
                  else if ( GXutil.strcmp(GXutil.trim( (String)AV18palabras.elementAt(-1+AV19i)), httpContext.getMessage( "M", "")) == 0 )
                  {
                     AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Detail( httpContext.getMessage( "Clase de legajo \"Mensual\".", "") );
                     AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation( httpContext.getMessage( "Ejemplo: {clase <b>M</b>}", "") );
                  }
                  else if ( GXutil.strcmp(GXutil.trim( (String)AV18palabras.elementAt(-1+AV19i)), httpContext.getMessage( "lunes", "")) == 0 )
                  {
                     AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Detail( httpContext.getMessage( "Recuperar valor configurado para el día \"Lunes\".", "") );
                     if ( GXutil.strcmp(A74idOperando, "[recargo]") == 0 )
                     {
                        AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation( httpContext.getMessage( "Ejemplo: {recargo nocturno <b>lunes</b>}", "") );
                     }
                     else
                     {
                        AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation( httpContext.getMessage( "Ejemplo: {extra diurno <b>lunes</b>}", "") );
                     }
                  }
                  else if ( GXutil.strcmp(GXutil.trim( (String)AV18palabras.elementAt(-1+AV19i)), httpContext.getMessage( "martes", "")) == 0 )
                  {
                     AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Detail( httpContext.getMessage( "Recuperar valor configurado para el día \"Martes\".", "") );
                     if ( GXutil.strcmp(A74idOperando, "[recargo]") == 0 )
                     {
                        AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation( httpContext.getMessage( "Ejemplo: {recargo nocturno <b>martes</b>}", "") );
                     }
                     else
                     {
                        AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation( httpContext.getMessage( "Ejemplo: {extra diurno <b>martes</b>}", "") );
                     }
                  }
                  else if ( GXutil.strcmp(GXutil.trim( (String)AV18palabras.elementAt(-1+AV19i)), httpContext.getMessage( "miercoles", "")) == 0 )
                  {
                     AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Detail( httpContext.getMessage( "Recuperar valor configurado para el día \"Miércoles\".", "") );
                     if ( GXutil.strcmp(A74idOperando, "[recargo]") == 0 )
                     {
                        AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation( httpContext.getMessage( "Ejemplo: {recargo nocturno <b>miercoles</b>}", "") );
                     }
                     else
                     {
                        AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation( httpContext.getMessage( "Ejemplo: {extra diurno <b>miercoles</b>}", "") );
                     }
                  }
                  else if ( GXutil.strcmp(GXutil.trim( (String)AV18palabras.elementAt(-1+AV19i)), httpContext.getMessage( "jueves", "")) == 0 )
                  {
                     AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Detail( httpContext.getMessage( "Recuperar valor configurado para el día \"Jueves\".", "") );
                     if ( GXutil.strcmp(A74idOperando, "[recargo]") == 0 )
                     {
                        AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation( httpContext.getMessage( "Ejemplo: {recargo nocturno <b>jueves</b>}", "") );
                     }
                     else
                     {
                        AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation( httpContext.getMessage( "Ejemplo: {extra diurno <b>jueves</b>}", "") );
                     }
                  }
                  else if ( GXutil.strcmp(GXutil.trim( (String)AV18palabras.elementAt(-1+AV19i)), httpContext.getMessage( "viernes", "")) == 0 )
                  {
                     AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Detail( httpContext.getMessage( "Recuperar valor configurado para el día \"Viernes\".", "") );
                     if ( GXutil.strcmp(A74idOperando, "[recargo]") == 0 )
                     {
                        AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation( httpContext.getMessage( "Ejemplo: {recargo nocturno <b>viernes</b>}", "") );
                     }
                     else
                     {
                        AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation( httpContext.getMessage( "Ejemplo: {extra diurno <b>viernes</b>}", "") );
                     }
                  }
                  else if ( GXutil.strcmp(GXutil.trim( (String)AV18palabras.elementAt(-1+AV19i)), httpContext.getMessage( "sabado", "")) == 0 )
                  {
                     AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Detail( httpContext.getMessage( "Recuperar valor configurado para el día \"Sábado\".", "") );
                     if ( GXutil.strcmp(A74idOperando, "[recargo]") == 0 )
                     {
                        AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation( httpContext.getMessage( "Ejemplo: {recargo nocturno <b>sabado</b>}", "") );
                     }
                     else
                     {
                        AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation( httpContext.getMessage( "Ejemplo: {extra diurno <b>sabado</b>}", "") );
                     }
                  }
                  else if ( GXutil.strcmp(GXutil.trim( (String)AV18palabras.elementAt(-1+AV19i)), httpContext.getMessage( "domingo", "")) == 0 )
                  {
                     AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Detail( httpContext.getMessage( "Recuperar valor configurado para el día \"Domingo\".", "") );
                     if ( GXutil.strcmp(A74idOperando, "[recargo]") == 0 )
                     {
                        AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation( httpContext.getMessage( "Ejemplo: {recargo nocturno <b>domingo</b>}", "") );
                     }
                     else
                     {
                        AV20itemSdtParLista.setgxTv_Sdtsdt_ParValLista_sdt_ParValListaItem_Documentation( httpContext.getMessage( "Ejemplo: {extra diurno <b>domingo</b>}", "") );
                     }
                  }
                  AV17sdt_ParValLista.add(AV20itemSdtParLista, 0);
                  AV19i = (short)(AV19i+1) ;
               }
               A2111CalParValLista = AV17sdt_ParValLista.toJSonString(false) ;
            }
            A2108CalParEjemplo = AV10item.getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Example() ;
            A2109CalParEjemExpli = "" ;
            A2110CalParNombre = AV10item.getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Name() ;
            A2100CalParDesc = AV10item.getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Description() ;
            A2104CalParGrp = (byte)(DecimalUtil.decToDouble(AV10item.getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Group())) ;
            A2105CalParGrpDep = (byte)(GXutil.lval( AV10item.getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Group_dependency())) ;
            A2106CalParObl = AV10item.getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Mandatory() ;
            A2107CalParDef = AV10item.getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Default() ;
            if ( ! (GXutil.strcmp("", AV10item.getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Documentation())==0) )
            {
               A2135CalParDoc = GXutil.trim( AV10item.getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Documentation()) ;
            }
            else
            {
               if ( ! (GXutil.strcmp("", AV10item.getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Example())==0) )
               {
                  A2135CalParDoc = httpContext.getMessage( "Ejemplo: ", "") + GXutil.trim( AV10item.getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Example()) ;
               }
            }
            A2136CalParDummy = AV10item.getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Dummy() ;
            A2137CalParDetail = AV10item.getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Detail() ;
            if ( ( GXutil.strcmp(A2098CalParId, "Adicional") == 0 ) || ( GXutil.strcmp(A2098CalParId, "AdicionalOpcion") == 0 ) || ( GXutil.strcmp(A2098CalParId, "Calculo") == 0 ) || ( GXutil.strcmp(A2098CalParId, "Clase") == 0 ) || ( GXutil.strcmp(A2098CalParId, "Convenio") == 0 ) || ( GXutil.strcmp(A2098CalParId, "Dia") == 0 ) || ( GXutil.strcmp(A2098CalParId, "Sexo") == 0 ) || ( GXutil.strcmp(A2098CalParId, "TipoDeConcepto") == 0 ) || ( GXutil.strcmp(A2098CalParId, "TipoLiq") == 0 ) || ( GXutil.strcmp(A2098CalParId, "Tipo de trabajo") == 0 ) || ( GXutil.strcmp(A2098CalParId, "PropiedadAdicional") == 0 ) )
            {
               A2141CalParSugGen = false ;
            }
            else
            {
               A2141CalParSugGen = true ;
            }
            /* Using cursor P01Z03 */
            pr_default.execute(1, new Object[] {Short.valueOf(A46PaiCod), A74idOperando, A2098CalParId, A2099CalParCampo, A2111CalParValLista, A2108CalParEjemplo, A2109CalParEjemExpli, A2100CalParDesc, Byte.valueOf(A2104CalParGrp), Byte.valueOf(A2105CalParGrpDep), Boolean.valueOf(A2106CalParObl), A2107CalParDef, A2110CalParNombre, A2137CalParDetail, A2135CalParDoc, A2136CalParDummy, Boolean.valueOf(A2141CalParSugGen)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("Calculo_parametros");
            if ( (pr_default.getStatus(1) == 1) )
            {
               Gx_err = (short)(1) ;
               Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
            }
            else
            {
               Gx_err = (short)(0) ;
               Gx_emsg = "" ;
            }
            /* End Insert */
            AV24GXV1 = (int)(AV24GXV1+1) ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "grabarcalpardesdejson");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV23Pgmname = "" ;
      AV9fecha = GXutil.nullDate() ;
      AV11json = "" ;
      GXv_char1 = new String[1] ;
      AV8error = "" ;
      GXv_char2 = new String[1] ;
      AV13sdt_cal_par_ini = new GXBaseCollection<web.Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item>(web.Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item.class, "sdt_cal_par_ini_2Item", "PayDay", remoteHandle);
      AV10item = new web.Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item(remoteHandle, context);
      AV12operandos = "" ;
      scmdbuf = "" ;
      P01Z02_A74idOperando = new String[] {""} ;
      P01Z02_A46PaiCod = new short[1] ;
      A74idOperando = "" ;
      AV16conCorchetes = "" ;
      AV14CalParId = "" ;
      A2098CalParId = "" ;
      A2099CalParCampo = "" ;
      A2111CalParValLista = "" ;
      AV18palabras = new GXSimpleCollection<String>(String.class, "internal", "");
      AV17sdt_ParValLista = new GXBaseCollection<web.Sdtsdt_ParValLista_sdt_ParValListaItem>(web.Sdtsdt_ParValLista_sdt_ParValListaItem.class, "sdt_ParValListaItem", "PayDay", remoteHandle);
      AV20itemSdtParLista = new web.Sdtsdt_ParValLista_sdt_ParValListaItem(remoteHandle, context);
      A2108CalParEjemplo = "" ;
      A2109CalParEjemExpli = "" ;
      A2110CalParNombre = "" ;
      A2100CalParDesc = "" ;
      A2107CalParDef = "" ;
      A2135CalParDoc = "" ;
      A2136CalParDummy = "" ;
      A2137CalParDetail = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.grabarcalpardesdejson__default(),
         new Object[] {
             new Object[] {
            P01Z02_A74idOperando, P01Z02_A46PaiCod
            }
            , new Object[] {
            }
         }
      );
      AV23Pgmname = "grabarCalParDesdeJson" ;
      /* GeneXus formulas. */
      AV23Pgmname = "grabarCalParDesdeJson" ;
      Gx_err = (short)(0) ;
   }

   private byte AV25GXLvl14 ;
   private byte A2104CalParGrp ;
   private byte A2105CalParGrpDep ;
   private short A46PaiCod ;
   private short AV19i ;
   private short Gx_err ;
   private int AV24GXV1 ;
   private int GX_INS265 ;
   private String AV23Pgmname ;
   private String GXv_char1[] ;
   private String GXv_char2[] ;
   private String AV12operandos ;
   private String scmdbuf ;
   private String A74idOperando ;
   private String AV14CalParId ;
   private String A2098CalParId ;
   private String A2107CalParDef ;
   private String Gx_emsg ;
   private java.util.Date AV9fecha ;
   private boolean AV15existe ;
   private boolean A2106CalParObl ;
   private boolean A2141CalParSugGen ;
   private String AV11json ;
   private String A2109CalParEjemExpli ;
   private String A2135CalParDoc ;
   private String AV8error ;
   private String AV16conCorchetes ;
   private String A2099CalParCampo ;
   private String A2111CalParValLista ;
   private String A2108CalParEjemplo ;
   private String A2110CalParNombre ;
   private String A2100CalParDesc ;
   private String A2136CalParDummy ;
   private String A2137CalParDetail ;
   private GXBaseCollection<web.Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item> AV13sdt_cal_par_ini ;
   private IDataStoreProvider pr_default ;
   private String[] P01Z02_A74idOperando ;
   private short[] P01Z02_A46PaiCod ;
   private GXSimpleCollection<String> AV18palabras ;
   private GXBaseCollection<web.Sdtsdt_ParValLista_sdt_ParValListaItem> AV17sdt_ParValLista ;
   private web.Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item AV10item ;
   private web.Sdtsdt_ParValLista_sdt_ParValListaItem AV20itemSdtParLista ;
}

final  class grabarcalpardesdejson__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01Z02", "SELECT idOperando, PaiCod FROM calculo WHERE (PaiCod = TO_NUMBER(0 || ?,'9999999999999999999999999999.99999999999999')) AND (idOperando = ( ?)) ORDER BY PaiCod, idOperando ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P01Z03", "SAVEPOINT gxupdate;INSERT INTO Calculo_parametros(PaiCod, idOperando, CalParId, CalParCampo, CalParValLista, CalParEjemplo, CalParEjemExpli, CalParDesc, CalParGrp, CalParGrpDep, CalParObl, CalParDef, CalParNombre, CalParDetail, CalParDoc, CalParDummy, CalParSugGen) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setVarchar(1, (String)parms[0], 400);
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setString(3, (String)parms[2], 40);
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setVarchar(5, (String)parms[4], 4000, false);
               stmt.setVarchar(6, (String)parms[5], 400, false);
               stmt.setNLongVarchar(7, (String)parms[6], false);
               stmt.setVarchar(8, (String)parms[7], 400, false);
               stmt.setByte(9, ((Number) parms[8]).byteValue());
               stmt.setByte(10, ((Number) parms[9]).byteValue());
               stmt.setBoolean(11, ((Boolean) parms[10]).booleanValue());
               stmt.setString(12, (String)parms[11], 20);
               stmt.setVarchar(13, (String)parms[12], 400, false);
               stmt.setVarchar(14, (String)parms[13], 400, false);
               stmt.setNLongVarchar(15, (String)parms[14], false);
               stmt.setVarchar(16, (String)parms[15], 40, false);
               stmt.setBoolean(17, ((Boolean) parms[16]).booleanValue());
               return;
      }
   }

}

