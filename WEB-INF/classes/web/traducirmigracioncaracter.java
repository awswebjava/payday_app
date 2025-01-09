package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class traducirmigracioncaracter extends GXProcedure
{
   public traducirmigracioncaracter( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( traducirmigracioncaracter.class ), "" );
   }

   public traducirmigracioncaracter( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             String aP4 ,
                             boolean aP5 ,
                             String aP6 ,
                             String aP7 ,
                             String aP8 ,
                             String aP9 ,
                             String[] aP10 ,
                             GXSimpleCollection<String>[] aP11 ,
                             GXSimpleCollection<String>[] aP12 ,
                             String[] aP13 ,
                             boolean[] aP14 ,
                             boolean[] aP15 ,
                             boolean[] aP16 )
   {
      traducirmigracioncaracter.this.aP17 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17);
      return aP17[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        String aP4 ,
                        boolean aP5 ,
                        String aP6 ,
                        String aP7 ,
                        String aP8 ,
                        String aP9 ,
                        String[] aP10 ,
                        GXSimpleCollection<String>[] aP11 ,
                        GXSimpleCollection<String>[] aP12 ,
                        String[] aP13 ,
                        boolean[] aP14 ,
                        boolean[] aP15 ,
                        boolean[] aP16 ,
                        String[] aP17 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             String aP4 ,
                             boolean aP5 ,
                             String aP6 ,
                             String aP7 ,
                             String aP8 ,
                             String aP9 ,
                             String[] aP10 ,
                             GXSimpleCollection<String>[] aP11 ,
                             GXSimpleCollection<String>[] aP12 ,
                             String[] aP13 ,
                             boolean[] aP14 ,
                             boolean[] aP15 ,
                             boolean[] aP16 ,
                             String[] aP17 )
   {
      traducirmigracioncaracter.this.AV13CliCod = aP0;
      traducirmigracioncaracter.this.AV17EmpCod = aP1;
      traducirmigracioncaracter.this.AV23MigrLegNumero = aP2;
      traducirmigracioncaracter.this.AV10campo = aP3;
      traducirmigracioncaracter.this.AV16Descrip = aP4;
      traducirmigracioncaracter.this.AV57parmGrabarNuevo = aP5;
      traducirmigracioncaracter.this.AV38codigoDependencia = aP6;
      traducirmigracioncaracter.this.AV48algoritmoEquivalenciasUsar = aP7;
      traducirmigracioncaracter.this.AV64MigrLegErrores = aP8;
      traducirmigracioncaracter.this.AV62MigrLegWarnings = aP9;
      traducirmigracioncaracter.this.aP10 = aP10;
      traducirmigracioncaracter.this.AV31errores = aP11[0];
      this.aP11 = aP11;
      traducirmigracioncaracter.this.AV27warnings = aP12[0];
      this.aP12 = aP12;
      traducirmigracioncaracter.this.aP13 = aP13;
      traducirmigracioncaracter.this.aP14 = aP14;
      traducirmigracioncaracter.this.aP15 = aP15;
      traducirmigracioncaracter.this.aP16 = aP16;
      traducirmigracioncaracter.this.aP17 = aP17;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV20grabarNuevo = AV57parmGrabarNuevo ;
      if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Categoria", "")) == 0 )
      {
         GXt_decimal1 = AV8MigrLegBasico ;
         GXv_decimal2[0] = GXt_decimal1 ;
         new web.getmigrbasico(remoteHandle, context).execute( AV13CliCod, AV17EmpCod, AV23MigrLegNumero, GXv_decimal2) ;
         traducirmigracioncaracter.this.GXt_decimal1 = GXv_decimal2[0] ;
         AV8MigrLegBasico = GXt_decimal1 ;
      }
      GXt_char3 = AV9auxDescrip ;
      GXv_char4[0] = GXt_char3 ;
      new web.sacaracentos2(remoteHandle, context).execute( GXutil.trim( AV16Descrip), GXv_char4) ;
      traducirmigracioncaracter.this.GXt_char3 = GXv_char4[0] ;
      AV9auxDescrip = GXt_char3 ;
      GXt_char3 = AV9auxDescrip ;
      GXv_char4[0] = GXt_char3 ;
      new web.defaulttextomigr(remoteHandle, context).execute( AV13CliCod, GXv_char4) ;
      traducirmigracioncaracter.this.GXt_char3 = GXv_char4[0] ;
      AV9auxDescrip = GXutil.strReplace( AV9auxDescrip, GXt_char3, "") ;
      AV47parmAuxDescrip = AV9auxDescrip ;
      GXv_char4[0] = AV9auxDescrip ;
      new web.reemplazosningunos(remoteHandle, context).execute( AV13CliCod, AV47parmAuxDescrip, GXv_char4) ;
      traducirmigracioncaracter.this.AV9auxDescrip = GXv_char4[0] ;
      GXv_int5[0] = AV41PaiCod ;
      new web.empresagetpais(remoteHandle, context).execute( AV13CliCod, AV17EmpCod, GXv_int5) ;
      traducirmigracioncaracter.this.AV41PaiCod = GXv_int5[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV71Pgmname, httpContext.getMessage( "campo ", "")+AV10campo+httpContext.getMessage( " auxdescrip ", "")+AV9auxDescrip+httpContext.getMessage( " &codigoDependencia ", "")+AV38codigoDependencia+httpContext.getMessage( " &clicod ", "")+GXutil.trim( GXutil.str( AV13CliCod, 6, 0))) ;
      AV32puedeCrear = true ;
      if ( ! (GXutil.strcmp("", AV9auxDescrip)==0) )
      {
         if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Area", "")) == 0 )
         {
            GXv_char4[0] = AV14Codigo ;
            GXv_boolean6[0] = AV19existe ;
            new web.getseccionpordescrip(remoteHandle, context).execute( AV13CliCod, GXutil.trim( AV9auxDescrip), GXv_char4, GXv_boolean6) ;
            traducirmigracioncaracter.this.AV14Codigo = GXv_char4[0] ;
            traducirmigracioncaracter.this.AV19existe = GXv_boolean6[0] ;
         }
         else if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Puesto", "")) == 0 )
         {
            GXv_char4[0] = AV14Codigo ;
            GXv_boolean6[0] = AV19existe ;
            new web.getareapuestopordescrip(remoteHandle, context).execute( AV13CliCod, AV38codigoDependencia, AV9auxDescrip, GXv_char4, GXv_boolean6) ;
            traducirmigracioncaracter.this.AV14Codigo = GXv_char4[0] ;
            traducirmigracioncaracter.this.AV19existe = GXv_boolean6[0] ;
         }
         else if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Categoria", "")) == 0 )
         {
            AV32puedeCrear = false ;
            if ( GXutil.strSearch( AV38codigoDependencia, ",", 1) == 0 )
            {
               AV52auxConveCodigo = AV38codigoDependencia ;
               AV59ZonCod = "" ;
            }
            else
            {
               AV56palabras.fromJSonString(AV38codigoDependencia, null);
               new web.msgdebug_prod(remoteHandle, context).execute( AV71Pgmname, httpContext.getMessage( "palabras to json", "")+AV56palabras.toJSonString(false)) ;
               if ( AV56palabras.size() != 2 )
               {
                  AV18error = httpContext.getMessage( "Eror al procesar código de categoría", "") ;
                  AV63auxError = AV18error ;
                  /* Execute user subroutine: 'AGREGAR ERROR' */
                  S121 ();
                  if ( returnInSub )
                  {
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
               }
               AV52auxConveCodigo = (String)AV56palabras.elementAt(-1+1) ;
               AV59ZonCod = (String)AV56palabras.elementAt(-1+2) ;
            }
            GXv_int7[0] = AV40CliConveVer ;
            new web.getversiondeconvenio(remoteHandle, context).execute( AV13CliCod, AV41PaiCod, GXutil.trim( AV52auxConveCodigo), GXv_int7) ;
            traducirmigracioncaracter.this.AV40CliConveVer = GXv_int7[0] ;
            GXv_char4[0] = AV37aux2Descrip ;
            GXv_boolean6[0] = AV19existe ;
            new web.getcategoria(remoteHandle, context).execute( AV13CliCod, AV40CliConveVer, AV52auxConveCodigo, GXutil.trim( AV9auxDescrip), GXv_char4, GXv_boolean6) ;
            traducirmigracioncaracter.this.AV37aux2Descrip = GXv_char4[0] ;
            traducirmigracioncaracter.this.AV19existe = GXv_boolean6[0] ;
            if ( AV19existe )
            {
               AV51auxCatCodigo = AV9auxDescrip ;
            }
            else
            {
               GXv_char4[0] = AV37aux2Descrip ;
               GXv_char8[0] = AV51auxCatCodigo ;
               GXv_boolean6[0] = AV19existe ;
               new web.getcategoriaporcodigoafip(remoteHandle, context).execute( AV13CliCod, AV40CliConveVer, AV52auxConveCodigo, AV9auxDescrip, AV59ZonCod, GXv_char4, GXv_char8, GXv_boolean6) ;
               traducirmigracioncaracter.this.AV37aux2Descrip = GXv_char4[0] ;
               traducirmigracioncaracter.this.AV51auxCatCodigo = GXv_char8[0] ;
               traducirmigracioncaracter.this.AV19existe = GXv_boolean6[0] ;
            }
            if ( ! AV19existe )
            {
               GXv_char8[0] = AV14Codigo ;
               GXv_boolean6[0] = AV19existe ;
               new web.getcategoriapordescrip(remoteHandle, context).execute( AV13CliCod, AV52auxConveCodigo, GXutil.trim( AV9auxDescrip), GXv_char8, GXv_boolean6) ;
               traducirmigracioncaracter.this.AV14Codigo = GXv_char8[0] ;
               traducirmigracioncaracter.this.AV19existe = GXv_boolean6[0] ;
            }
            else
            {
               AV36esCodigo = true ;
               AV14Codigo = AV51auxCatCodigo ;
               AV9auxDescrip = AV37aux2Descrip ;
            }
            new web.msgdebug_prod(remoteHandle, context).execute( AV71Pgmname, httpContext.getMessage( "&auxConveCodigo ", "")+AV52auxConveCodigo) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV71Pgmname, httpContext.getMessage( "existe ", "")+GXutil.trim( GXutil.booltostr( AV19existe))+httpContext.getMessage( " &codigoDependencia ", "")+AV38codigoDependencia+httpContext.getMessage( " &CliConveVer ", "")+GXutil.trim( GXutil.str( AV40CliConveVer, 6, 0))+httpContext.getMessage( " &auxDescrip ", "")+AV9auxDescrip+httpContext.getMessage( " &aux2Descrip ", "")+AV37aux2Descrip+httpContext.getMessage( " &esCodigo ", "")+GXutil.trim( GXutil.booltostr( AV36esCodigo))) ;
         }
         else if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Banco", "")) == 0 )
         {
            AV33BanCod = GXutil.padl( GXutil.trim( AV9auxDescrip), (short)(5), "0") ;
            GXv_char8[0] = AV37aux2Descrip ;
            GXv_boolean6[0] = AV19existe ;
            new web.getbanco(remoteHandle, context).execute( AV13CliCod, AV33BanCod, GXv_char8, GXv_boolean6) ;
            traducirmigracioncaracter.this.AV37aux2Descrip = GXv_char8[0] ;
            traducirmigracioncaracter.this.AV19existe = GXv_boolean6[0] ;
            if ( ! AV19existe )
            {
               GXv_char8[0] = AV14Codigo ;
               GXv_boolean6[0] = AV19existe ;
               new web.getbancopordescrip(remoteHandle, context).execute( AV13CliCod, GXutil.trim( AV9auxDescrip), GXv_char8, GXv_boolean6) ;
               traducirmigracioncaracter.this.AV14Codigo = GXv_char8[0] ;
               traducirmigracioncaracter.this.AV19existe = GXv_boolean6[0] ;
            }
            else
            {
               AV36esCodigo = true ;
               AV14Codigo = AV9auxDescrip ;
               AV9auxDescrip = AV37aux2Descrip ;
            }
         }
         else if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Obra Social", "")) == 0 )
         {
            GXv_char8[0] = AV14Codigo ;
            GXv_boolean6[0] = AV19existe ;
            new web.getobrasocialporcodigoafip(remoteHandle, context).execute( AV13CliCod, GXutil.strReplace( GXutil.trim( AV9auxDescrip), "-", ""), GXv_char8, GXv_boolean6) ;
            traducirmigracioncaracter.this.AV14Codigo = GXv_char8[0] ;
            traducirmigracioncaracter.this.AV19existe = GXv_boolean6[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV71Pgmname, httpContext.getMessage( "ossssssssss &existe ", "")+GXutil.trim( GXutil.booltostr( AV19existe))+httpContext.getMessage( " &auxDescrip ", "")+GXutil.trim( AV9auxDescrip)) ;
            if ( ! AV19existe )
            {
               GXv_char8[0] = AV14Codigo ;
               GXv_boolean6[0] = AV19existe ;
               new web.getobrasocialporsigla(remoteHandle, context).execute( AV13CliCod, GXutil.trim( AV9auxDescrip), GXv_char8, GXv_boolean6) ;
               traducirmigracioncaracter.this.AV14Codigo = GXv_char8[0] ;
               traducirmigracioncaracter.this.AV19existe = GXv_boolean6[0] ;
               if ( ! AV19existe )
               {
                  GXv_char8[0] = AV14Codigo ;
                  GXv_boolean6[0] = AV19existe ;
                  new web.getobrasocialpordescrip(remoteHandle, context).execute( AV13CliCod, GXutil.trim( AV9auxDescrip), GXv_char8, GXv_boolean6) ;
                  traducirmigracioncaracter.this.AV14Codigo = GXv_char8[0] ;
                  traducirmigracioncaracter.this.AV19existe = GXv_boolean6[0] ;
               }
               else
               {
                  AV28MigrEncontroOsoSigla = true ;
                  new web.setmigrencontroososigla(remoteHandle, context).execute( AV13CliCod, AV17EmpCod, AV23MigrLegNumero, AV28MigrEncontroOsoSigla) ;
               }
            }
            else
            {
               AV43MigrEncontroOsoAfip = true ;
               new web.setmigrencontroosoafip(remoteHandle, context).execute( AV13CliCod, AV17EmpCod, AV23MigrLegNumero, AV43MigrEncontroOsoAfip) ;
            }
            if ( AV19existe )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV71Pgmname, httpContext.getMessage( "&Codigo ", "")+AV14Codigo+httpContext.getMessage( " llama a ActualizarMigrOSAfip ", "")) ;
               new web.actualizarmigrosafip(remoteHandle, context).execute( AV13CliCod, AV17EmpCod, AV23MigrLegNumero, GXutil.trim( AV14Codigo)) ;
            }
         }
         else if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Actividad", "")) == 0 )
         {
            GXv_char8[0] = AV65ActCodigo ;
            new web.getcodigomigracionafip(remoteHandle, context).execute( AV9auxDescrip, GXv_char8) ;
            traducirmigracioncaracter.this.AV65ActCodigo = GXv_char8[0] ;
            GXv_char8[0] = AV37aux2Descrip ;
            GXv_boolean6[0] = AV19existe ;
            new web.getactividad(remoteHandle, context).execute( AV65ActCodigo, GXv_char8, GXv_boolean6) ;
            traducirmigracioncaracter.this.AV37aux2Descrip = GXv_char8[0] ;
            traducirmigracioncaracter.this.AV19existe = GXv_boolean6[0] ;
            if ( ! AV19existe )
            {
               GXv_char8[0] = AV14Codigo ;
               GXv_boolean6[0] = AV19existe ;
               new web.getactividadpordescrip(remoteHandle, context).execute( GXutil.trim( AV9auxDescrip), GXv_char8, GXv_boolean6) ;
               traducirmigracioncaracter.this.AV14Codigo = GXv_char8[0] ;
               traducirmigracioncaracter.this.AV19existe = GXv_boolean6[0] ;
            }
            else
            {
               AV36esCodigo = true ;
               AV14Codigo = AV9auxDescrip ;
               AV9auxDescrip = AV37aux2Descrip ;
            }
            AV32puedeCrear = false ;
         }
         else if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Actividad laboral AFIP", "")) == 0 )
         {
            if ( CommonUtil.decimalVal( AV9auxDescrip, ".").doubleValue() > 0 )
            {
               GXv_char8[0] = AV37aux2Descrip ;
               GXv_char4[0] = "" ;
               GXv_boolean6[0] = AV19existe ;
               new web.getactlabclasificada(remoteHandle, context).execute( AV41PaiCod, (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( AV9auxDescrip, "."))), GXv_char8, GXv_char4, GXv_boolean6) ;
               traducirmigracioncaracter.this.AV37aux2Descrip = GXv_char8[0] ;
               traducirmigracioncaracter.this.AV19existe = GXv_boolean6[0] ;
            }
            if ( ! AV19existe )
            {
               GXv_int7[0] = AV15CodigoNum ;
               GXv_boolean6[0] = AV19existe ;
               new web.getactlabclasifpordescrip(remoteHandle, context).execute( AV41PaiCod, GXutil.trim( AV9auxDescrip), GXv_int7, GXv_boolean6) ;
               traducirmigracioncaracter.this.AV15CodigoNum = (short)((short)(GXv_int7[0])) ;
               traducirmigracioncaracter.this.AV19existe = GXv_boolean6[0] ;
               AV14Codigo = GXutil.trim( GXutil.str( AV15CodigoNum, 4, 0)) ;
            }
            else
            {
               AV36esCodigo = true ;
               AV14Codigo = AV9auxDescrip ;
               AV9auxDescrip = AV37aux2Descrip ;
            }
            AV32puedeCrear = false ;
         }
         else if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Puesto AFIP", "")) == 0 )
         {
            GXv_char8[0] = AV37aux2Descrip ;
            GXv_boolean6[0] = AV19existe ;
            new web.getpuestoafip(remoteHandle, context).execute( GXutil.trim( AV9auxDescrip), GXv_char8, GXv_boolean6) ;
            traducirmigracioncaracter.this.AV37aux2Descrip = GXv_char8[0] ;
            traducirmigracioncaracter.this.AV19existe = GXv_boolean6[0] ;
            if ( ! AV19existe )
            {
               GXv_char8[0] = AV14Codigo ;
               GXv_boolean6[0] = AV19existe ;
               new web.getpuestoafippordescripsinac(remoteHandle, context).execute( GXutil.trim( AV9auxDescrip), GXv_char8, GXv_boolean6) ;
               traducirmigracioncaracter.this.AV14Codigo = GXv_char8[0] ;
               traducirmigracioncaracter.this.AV19existe = GXv_boolean6[0] ;
            }
            else
            {
               AV36esCodigo = true ;
               AV14Codigo = AV9auxDescrip ;
               AV9auxDescrip = AV37aux2Descrip ;
            }
            AV32puedeCrear = false ;
         }
         else if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Modalidad", "")) == 0 )
         {
            GXv_char8[0] = AV34MprCod ;
            new web.getcodigomigracionafip(remoteHandle, context).execute( AV9auxDescrip, GXv_char8) ;
            traducirmigracioncaracter.this.AV34MprCod = GXv_char8[0] ;
            GXv_char8[0] = AV37aux2Descrip ;
            GXv_boolean6[0] = AV19existe ;
            new web.getmodalidad(remoteHandle, context).execute( AV34MprCod, GXv_char8, GXv_boolean6) ;
            traducirmigracioncaracter.this.AV37aux2Descrip = GXv_char8[0] ;
            traducirmigracioncaracter.this.AV19existe = GXv_boolean6[0] ;
            if ( ! AV19existe )
            {
               GXv_char8[0] = AV14Codigo ;
               GXv_boolean6[0] = AV19existe ;
               new web.getmodalidadpordescrip(remoteHandle, context).execute( GXutil.trim( AV9auxDescrip), GXv_char8, GXv_boolean6) ;
               traducirmigracioncaracter.this.AV14Codigo = GXv_char8[0] ;
               traducirmigracioncaracter.this.AV19existe = GXv_boolean6[0] ;
            }
            else
            {
               AV36esCodigo = true ;
               AV14Codigo = AV9auxDescrip ;
               AV9auxDescrip = AV37aux2Descrip ;
            }
            AV32puedeCrear = false ;
         }
         else if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Parentesco", "")) == 0 )
         {
            GXv_char8[0] = AV14Codigo ;
            GXv_boolean6[0] = AV19existe ;
            new web.getparentescopordescrip(remoteHandle, context).execute( AV13CliCod, GXutil.trim( AV9auxDescrip), GXv_char8, GXv_boolean6) ;
            traducirmigracioncaracter.this.AV14Codigo = GXv_char8[0] ;
            traducirmigracioncaracter.this.AV19existe = GXv_boolean6[0] ;
            AV32puedeCrear = false ;
         }
         else if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Zona", "")) == 0 )
         {
            GXv_char8[0] = AV68auxZonCod ;
            new web.getcodigomigracionafip(remoteHandle, context).execute( AV9auxDescrip, GXv_char8) ;
            traducirmigracioncaracter.this.AV68auxZonCod = GXv_char8[0] ;
            GXv_char8[0] = AV37aux2Descrip ;
            GXv_boolean6[0] = AV19existe ;
            new web.getzona(remoteHandle, context).execute( AV68auxZonCod, GXv_char8, GXv_boolean6) ;
            traducirmigracioncaracter.this.AV37aux2Descrip = GXv_char8[0] ;
            traducirmigracioncaracter.this.AV19existe = GXv_boolean6[0] ;
            if ( ! AV19existe )
            {
               GXv_char8[0] = AV14Codigo ;
               GXv_boolean6[0] = AV19existe ;
               new web.getzonapordescrip(remoteHandle, context).execute( GXutil.trim( AV9auxDescrip), GXv_char8, GXv_boolean6) ;
               traducirmigracioncaracter.this.AV14Codigo = GXv_char8[0] ;
               traducirmigracioncaracter.this.AV19existe = GXv_boolean6[0] ;
            }
            else
            {
               AV36esCodigo = true ;
               AV14Codigo = AV9auxDescrip ;
               AV9auxDescrip = AV37aux2Descrip ;
            }
            AV32puedeCrear = false ;
         }
         else if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Situacion", "")) == 0 )
         {
            GXv_char8[0] = AV37aux2Descrip ;
            GXv_boolean6[0] = AV19existe ;
            new web.getsituacion(remoteHandle, context).execute( GXutil.trim( AV9auxDescrip), GXv_char8, GXv_boolean6) ;
            traducirmigracioncaracter.this.AV37aux2Descrip = GXv_char8[0] ;
            traducirmigracioncaracter.this.AV19existe = GXv_boolean6[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV71Pgmname, httpContext.getMessage( "situacion ", "")+AV9auxDescrip+" * "+AV37aux2Descrip+httpContext.getMessage( " existe ", "")+GXutil.trim( GXutil.booltostr( AV19existe))) ;
            if ( ! AV19existe )
            {
               GXv_char8[0] = AV14Codigo ;
               GXv_boolean6[0] = AV19existe ;
               new web.getsituacionpordescrip(remoteHandle, context).execute( GXutil.trim( AV9auxDescrip), GXv_char8, GXv_boolean6) ;
               traducirmigracioncaracter.this.AV14Codigo = GXv_char8[0] ;
               traducirmigracioncaracter.this.AV19existe = GXv_boolean6[0] ;
            }
            else
            {
               AV36esCodigo = true ;
               AV14Codigo = AV9auxDescrip ;
               AV9auxDescrip = AV37aux2Descrip ;
            }
            AV32puedeCrear = false ;
         }
         else if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Condicion", "")) == 0 )
         {
            GXv_char8[0] = AV66palabra ;
            new web.getcodigomigracionafip(remoteHandle, context).execute( AV9auxDescrip, GXv_char8) ;
            traducirmigracioncaracter.this.AV66palabra = GXv_char8[0] ;
            AV35CondiCodigo = (short)(GXutil.lval( AV66palabra)) ;
            GXv_char8[0] = AV37aux2Descrip ;
            GXv_boolean6[0] = AV19existe ;
            new web.getcondicion(remoteHandle, context).execute( AV35CondiCodigo, GXv_char8, GXv_boolean6) ;
            traducirmigracioncaracter.this.AV37aux2Descrip = GXv_char8[0] ;
            traducirmigracioncaracter.this.AV19existe = GXv_boolean6[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV71Pgmname, httpContext.getMessage( "condición &CondiCodigo ", "")+GXutil.trim( GXutil.str( AV35CondiCodigo, 4, 0))+httpContext.getMessage( " existe ", "")+GXutil.trim( GXutil.booltostr( AV19existe))) ;
            if ( ! AV19existe )
            {
               GXv_int5[0] = AV15CodigoNum ;
               GXv_boolean6[0] = AV19existe ;
               new web.getcondicionpordescrip(remoteHandle, context).execute( GXutil.trim( AV9auxDescrip), GXv_int5, GXv_boolean6) ;
               traducirmigracioncaracter.this.AV15CodigoNum = GXv_int5[0] ;
               traducirmigracioncaracter.this.AV19existe = GXv_boolean6[0] ;
               AV14Codigo = GXutil.trim( GXutil.str( AV15CodigoNum, 4, 0)) ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV71Pgmname, httpContext.getMessage( "condición &auxDescrip ", "")+GXutil.trim( AV9auxDescrip)+httpContext.getMessage( " codignum ", "")+GXutil.trim( GXutil.str( AV15CodigoNum, 4, 0))+httpContext.getMessage( " codigo ", "")+GXutil.trim( AV14Codigo)+httpContext.getMessage( " existe ", "")+GXutil.trim( GXutil.booltostr( AV19existe))) ;
            }
            else
            {
               AV36esCodigo = true ;
               AV14Codigo = AV9auxDescrip ;
               AV9auxDescrip = AV37aux2Descrip ;
            }
            AV32puedeCrear = false ;
         }
         else if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Siniestrado", "")) == 0 )
         {
            AV32puedeCrear = false ;
            GXv_char8[0] = AV37aux2Descrip ;
            GXv_boolean6[0] = AV19existe ;
            new web.getsiniestrado(remoteHandle, context).execute( GXutil.trim( AV9auxDescrip), GXv_char8, GXv_boolean6) ;
            traducirmigracioncaracter.this.AV37aux2Descrip = GXv_char8[0] ;
            traducirmigracioncaracter.this.AV19existe = GXv_boolean6[0] ;
            if ( ! AV19existe )
            {
               GXv_char8[0] = AV14Codigo ;
               GXv_boolean6[0] = AV19existe ;
               new web.getsiniestradopordescrip(remoteHandle, context).execute( GXutil.trim( AV9auxDescrip), GXv_char8, GXv_boolean6) ;
               traducirmigracioncaracter.this.AV14Codigo = GXv_char8[0] ;
               traducirmigracioncaracter.this.AV19existe = GXv_boolean6[0] ;
            }
            else
            {
               AV36esCodigo = true ;
               AV14Codigo = AV9auxDescrip ;
               AV9auxDescrip = AV37aux2Descrip ;
            }
         }
         else if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Convenio", "")) == 0 )
         {
            AV32puedeCrear = false ;
            GXv_char8[0] = AV37aux2Descrip ;
            GXv_boolean6[0] = AV19existe ;
            new web.getconvenio(remoteHandle, context).execute( AV13CliCod, GXutil.trim( AV9auxDescrip), GXv_char8, GXv_boolean6) ;
            traducirmigracioncaracter.this.AV37aux2Descrip = GXv_char8[0] ;
            traducirmigracioncaracter.this.AV19existe = GXv_boolean6[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV71Pgmname, httpContext.getMessage( "convenio &existe ", "")+GXutil.trim( GXutil.booltostr( AV19existe))+httpContext.getMessage( " &auxDescrip ", "")+AV9auxDescrip) ;
            if ( ! AV19existe )
            {
               GXv_char8[0] = AV14Codigo ;
               GXv_boolean6[0] = AV19existe ;
               new web.getconveniopordescrip(remoteHandle, context).execute( AV13CliCod, AV41PaiCod, "", GXutil.trim( AV9auxDescrip), GXv_char8, GXv_boolean6) ;
               traducirmigracioncaracter.this.AV14Codigo = GXv_char8[0] ;
               traducirmigracioncaracter.this.AV19existe = GXv_boolean6[0] ;
            }
            else
            {
               AV36esCodigo = true ;
               AV14Codigo = AV9auxDescrip ;
               AV9auxDescrip = AV37aux2Descrip ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV71Pgmname, httpContext.getMessage( "convenio &Codigo ", "")+AV14Codigo) ;
            }
         }
         else if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Sindicato", "")) == 0 )
         {
            AV32puedeCrear = false ;
            GXv_char8[0] = AV37aux2Descrip ;
            GXv_boolean6[0] = AV19existe ;
            new web.getsindicato(remoteHandle, context).execute( AV13CliCod, GXutil.trim( AV9auxDescrip), GXv_char8, GXv_boolean6) ;
            traducirmigracioncaracter.this.AV37aux2Descrip = GXv_char8[0] ;
            traducirmigracioncaracter.this.AV19existe = GXv_boolean6[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV71Pgmname, httpContext.getMessage( "&auxDescrip ", "")+AV9auxDescrip+httpContext.getMessage( " &aux2Descrip ", "")+AV37aux2Descrip+httpContext.getMessage( " existe ", "")+GXutil.trim( GXutil.booltostr( AV19existe))) ;
            if ( ! AV19existe )
            {
               GXt_char3 = AV39ActComCodigo ;
               GXv_char8[0] = GXt_char3 ;
               new web.empresagetactcomercial(remoteHandle, context).execute( AV13CliCod, AV17EmpCod, GXv_char8) ;
               traducirmigracioncaracter.this.GXt_char3 = GXv_char8[0] ;
               AV39ActComCodigo = GXt_char3 ;
               GXv_char8[0] = AV14Codigo ;
               GXv_boolean6[0] = AV19existe ;
               new web.getsindicatopordescrip(remoteHandle, context).execute( AV39ActComCodigo, GXutil.trim( AV9auxDescrip), GXv_char8, GXv_boolean6) ;
               traducirmigracioncaracter.this.AV14Codigo = GXv_char8[0] ;
               traducirmigracioncaracter.this.AV19existe = GXv_boolean6[0] ;
            }
            else
            {
               AV36esCodigo = true ;
               AV14Codigo = AV9auxDescrip ;
               AV9auxDescrip = AV37aux2Descrip ;
            }
         }
         if ( ! AV19existe )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV71Pgmname, httpContext.getMessage( "&auxDescrip ", "")+AV9auxDescrip) ;
            AV26seguir = true ;
            AV44originalDescrip = AV9auxDescrip ;
            AV45busquedas = (short)(0) ;
            AV21hayLike = false ;
            AV50equivalente = false ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV71Pgmname, httpContext.getMessage( "&algoritmoEquivalenciasUsar ", "")+AV48algoritmoEquivalenciasUsar) ;
            if ( GXutil.strcmp(AV48algoritmoEquivalenciasUsar, "Algoritmo1") == 0 )
            {
               while ( AV26seguir )
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV71Pgmname, httpContext.getMessage( "seguir ", "")+GXutil.booltostr( AV26seguir)+httpContext.getMessage( " &auxDescrip ", "")+GXutil.trim( AV9auxDescrip)+httpContext.getMessage( " haylike ", "")+GXutil.trim( GXutil.booltostr( AV21hayLike))) ;
                  if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Area", "")) == 0 )
                  {
                     GXv_char8[0] = AV14Codigo ;
                     GXv_boolean6[0] = AV21hayLike ;
                     new web.getseccionlikedescrip(remoteHandle, context).execute( AV13CliCod, GXutil.trim( AV9auxDescrip), GXv_char8, GXv_boolean6) ;
                     traducirmigracioncaracter.this.AV14Codigo = GXv_char8[0] ;
                     traducirmigracioncaracter.this.AV21hayLike = GXv_boolean6[0] ;
                  }
                  else if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Categoria", "")) == 0 )
                  {
                     GXv_char8[0] = AV14Codigo ;
                     GXv_boolean6[0] = AV21hayLike ;
                     new web.getcategorialikedescrip(remoteHandle, context).execute( AV13CliCod, AV38codigoDependencia, GXutil.trim( AV9auxDescrip), GXv_char8, GXv_boolean6) ;
                     traducirmigracioncaracter.this.AV14Codigo = GXv_char8[0] ;
                     traducirmigracioncaracter.this.AV21hayLike = GXv_boolean6[0] ;
                     if ( GXutil.strcmp(AV9auxDescrip, "999999") == 0 )
                     {
                        AV50equivalente = true ;
                     }
                  }
                  else if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Banco", "")) == 0 )
                  {
                     GXv_char8[0] = AV14Codigo ;
                     GXv_boolean6[0] = AV21hayLike ;
                     new web.getbancolikedescrip(remoteHandle, context).execute( AV13CliCod, GXutil.trim( AV9auxDescrip), GXv_char8, GXv_boolean6) ;
                     traducirmigracioncaracter.this.AV14Codigo = GXv_char8[0] ;
                     traducirmigracioncaracter.this.AV21hayLike = GXv_boolean6[0] ;
                  }
                  else if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Sindicato", "")) == 0 )
                  {
                     GXv_char8[0] = AV14Codigo ;
                     GXv_boolean6[0] = AV21hayLike ;
                     new web.getsindicatolikedescrip(remoteHandle, context).execute( AV13CliCod, GXutil.trim( AV9auxDescrip), GXv_char8, GXv_boolean6) ;
                     traducirmigracioncaracter.this.AV14Codigo = GXv_char8[0] ;
                     traducirmigracioncaracter.this.AV21hayLike = GXv_boolean6[0] ;
                  }
                  else if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Obra Social", "")) == 0 )
                  {
                     GXv_char8[0] = AV14Codigo ;
                     GXv_boolean6[0] = AV21hayLike ;
                     new web.getobrasociallikedescrip(remoteHandle, context).execute( AV13CliCod, GXutil.trim( AV9auxDescrip), GXv_char8, GXv_boolean6) ;
                     traducirmigracioncaracter.this.AV14Codigo = GXv_char8[0] ;
                     traducirmigracioncaracter.this.AV21hayLike = GXv_boolean6[0] ;
                     new web.msgdebug_prod(remoteHandle, context).execute( AV71Pgmname, httpContext.getMessage( "busca por descrip &hayLike ", "")+GXutil.trim( GXutil.booltostr( AV21hayLike))) ;
                  }
                  else if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Actividad", "")) == 0 )
                  {
                     GXv_char8[0] = AV14Codigo ;
                     GXv_boolean6[0] = AV21hayLike ;
                     new web.getactividadlikedescrip(remoteHandle, context).execute( GXutil.trim( AV9auxDescrip), GXv_char8, GXv_boolean6) ;
                     traducirmigracioncaracter.this.AV14Codigo = GXv_char8[0] ;
                     traducirmigracioncaracter.this.AV21hayLike = GXv_boolean6[0] ;
                  }
                  else if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Modalidad", "")) == 0 )
                  {
                     GXv_char8[0] = AV14Codigo ;
                     GXv_boolean6[0] = AV21hayLike ;
                     new web.getmodalidadlikedescrip(remoteHandle, context).execute( GXutil.trim( AV9auxDescrip), GXv_char8, GXv_boolean6) ;
                     traducirmigracioncaracter.this.AV14Codigo = GXv_char8[0] ;
                     traducirmigracioncaracter.this.AV21hayLike = GXv_boolean6[0] ;
                  }
                  else if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Parentesco", "")) == 0 )
                  {
                     GXv_char8[0] = AV14Codigo ;
                     GXv_char4[0] = AV49ParDescripSinAc ;
                     GXv_boolean6[0] = AV21hayLike ;
                     new web.getparentescolikedescrip(remoteHandle, context).execute( AV13CliCod, GXutil.trim( AV9auxDescrip), GXv_char8, GXv_char4, GXv_boolean6) ;
                     traducirmigracioncaracter.this.AV14Codigo = GXv_char8[0] ;
                     traducirmigracioncaracter.this.AV49ParDescripSinAc = GXv_char4[0] ;
                     traducirmigracioncaracter.this.AV21hayLike = GXv_boolean6[0] ;
                  }
                  else if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Zona", "")) == 0 )
                  {
                     GXv_char8[0] = AV14Codigo ;
                     GXv_boolean6[0] = AV21hayLike ;
                     new web.getzonalikedescrip(remoteHandle, context).execute( GXutil.trim( AV9auxDescrip), GXv_char8, GXv_boolean6) ;
                     traducirmigracioncaracter.this.AV14Codigo = GXv_char8[0] ;
                     traducirmigracioncaracter.this.AV21hayLike = GXv_boolean6[0] ;
                  }
                  else if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Situacion", "")) == 0 )
                  {
                     GXv_char8[0] = AV14Codigo ;
                     GXv_boolean6[0] = AV21hayLike ;
                     new web.getsituacionlikedescrip(remoteHandle, context).execute( GXutil.trim( AV9auxDescrip), GXv_char8, GXv_boolean6) ;
                     traducirmigracioncaracter.this.AV14Codigo = GXv_char8[0] ;
                     traducirmigracioncaracter.this.AV21hayLike = GXv_boolean6[0] ;
                  }
                  else if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Convenio", "")) == 0 )
                  {
                     GXv_char8[0] = AV14Codigo ;
                     GXv_boolean6[0] = AV21hayLike ;
                     new web.getconveniolikedescrip(remoteHandle, context).execute( AV13CliCod, GXutil.trim( AV9auxDescrip), GXv_char8, GXv_boolean6) ;
                     traducirmigracioncaracter.this.AV14Codigo = GXv_char8[0] ;
                     traducirmigracioncaracter.this.AV21hayLike = GXv_boolean6[0] ;
                  }
                  else if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Condicion", "")) == 0 )
                  {
                     GXv_int5[0] = AV15CodigoNum ;
                     GXv_boolean6[0] = AV21hayLike ;
                     new web.getcondicionlikedescrip(remoteHandle, context).execute( GXutil.trim( AV9auxDescrip), GXv_int5, GXv_boolean6) ;
                     traducirmigracioncaracter.this.AV15CodigoNum = GXv_int5[0] ;
                     traducirmigracioncaracter.this.AV21hayLike = GXv_boolean6[0] ;
                     AV14Codigo = GXutil.trim( GXutil.str( AV15CodigoNum, 4, 0)) ;
                  }
                  else if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Siniestrado", "")) == 0 )
                  {
                     GXv_char8[0] = AV14Codigo ;
                     GXv_boolean6[0] = AV21hayLike ;
                     new web.getsiniestradolikedescrip(remoteHandle, context).execute( GXutil.trim( AV9auxDescrip), GXv_char8, GXv_boolean6) ;
                     traducirmigracioncaracter.this.AV14Codigo = GXv_char8[0] ;
                     traducirmigracioncaracter.this.AV21hayLike = GXv_boolean6[0] ;
                  }
                  else if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Puesto", "")) == 0 )
                  {
                     if ( AV55fueraConvenioEs )
                     {
                        GXv_char8[0] = AV14Codigo ;
                        GXv_boolean6[0] = AV21hayLike ;
                        new web.getpuestodearealikedescrip(remoteHandle, context).execute( AV13CliCod, AV53auxSecCodigo, AV9auxDescrip, GXv_char8, GXv_boolean6) ;
                        traducirmigracioncaracter.this.AV14Codigo = GXv_char8[0] ;
                        traducirmigracioncaracter.this.AV21hayLike = GXv_boolean6[0] ;
                     }
                     else
                     {
                        GXv_char8[0] = AV14Codigo ;
                        GXv_boolean6[0] = AV21hayLike ;
                        new web.getpuestodeafiplikedescrip(remoteHandle, context).execute( AV9auxDescrip, GXv_char8, GXv_boolean6) ;
                        traducirmigracioncaracter.this.AV14Codigo = GXv_char8[0] ;
                        traducirmigracioncaracter.this.AV21hayLike = GXv_boolean6[0] ;
                     }
                  }
                  else
                  {
                     AV26seguir = false ;
                  }
                  if ( AV21hayLike )
                  {
                     AV26seguir = false ;
                     if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Parentesco", "")) == 0 )
                     {
                        GXv_boolean6[0] = AV50equivalente ;
                        new web.validarequivalencia(remoteHandle, context).execute( GXutil.trim( AV9auxDescrip), AV49ParDescripSinAc, GXv_boolean6) ;
                        traducirmigracioncaracter.this.AV50equivalente = GXv_boolean6[0] ;
                        if ( AV50equivalente )
                        {
                           AV19existe = true ;
                           AV21hayLike = false ;
                        }
                     }
                  }
                  if ( ! AV21hayLike )
                  {
                     if ( AV45busquedas == 0 )
                     {
                        GXv_char8[0] = AV9auxDescrip ;
                        new web.eliminarultimapalabra(remoteHandle, context).execute( GXv_char8) ;
                        traducirmigracioncaracter.this.AV9auxDescrip = GXv_char8[0] ;
                     }
                     else
                     {
                        GXv_char8[0] = AV9auxDescrip ;
                        new web.eliminarprimerapalabra(remoteHandle, context).execute( GXv_char8) ;
                        traducirmigracioncaracter.this.AV9auxDescrip = GXv_char8[0] ;
                     }
                     if ( (GXutil.strcmp("", AV9auxDescrip)==0) || ( GXutil.len( AV9auxDescrip) <= 4 ) )
                     {
                        AV45busquedas = (short)(AV45busquedas+1) ;
                        if ( AV45busquedas == 2 )
                        {
                           AV26seguir = false ;
                        }
                        else
                        {
                           AV9auxDescrip = AV44originalDescrip ;
                        }
                     }
                  }
               }
            }
            new web.msgdebug_prod(remoteHandle, context).execute( AV71Pgmname, httpContext.getMessage( "campo ", "")+AV10campo+httpContext.getMessage( " GRABAR NUEVO ", "")+GXutil.trim( GXutil.booltostr( AV20grabarNuevo))+httpContext.getMessage( " &hayLike ", "")+GXutil.trim( GXutil.booltostr( AV21hayLike))+httpContext.getMessage( " &equivalente ", "")+GXutil.trim( GXutil.booltostr( AV50equivalente))) ;
            if ( ! AV50equivalente )
            {
               if ( ! AV20grabarNuevo )
               {
                  if ( AV21hayLike )
                  {
                     new web.msgdebug_prod(remoteHandle, context).execute( AV71Pgmname, httpContext.getMessage( "hay laik ", "")+AV9auxDescrip) ;
                     new web.msgdebug_prod(remoteHandle, context).execute( AV71Pgmname, httpContext.getMessage( "hay likeeee ", "")+AV9auxDescrip) ;
                     if ( GXutil.strcmp(GXutil.trim( AV9auxDescrip), GXutil.trim( AV47parmAuxDescrip)) != 0 )
                     {
                        AV58puntosSuspensivosEs = true ;
                     }
                     else
                     {
                        AV58puntosSuspensivosEs = false ;
                     }
                     if ( ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Actividad", "")) == 0 ) || ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Modalidad", "")) == 0 ) || ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Zona", "")) == 0 ) || ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Situacion", "")) == 0 ) || ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Condicion", "")) == 0 ) || ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Siniestrado", "")) == 0 ) || ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Convenio", "")) == 0 ) || ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Sindicato", "")) == 0 ) || ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Categoria", "")) == 0 ) || ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Parentesco", "")) == 0 ) )
                     {
                        GXt_char3 = AV63auxError ;
                        GXv_char8[0] = GXt_char3 ;
                        new web.mensajeseleccionaropcionmigracionexisten(remoteHandle, context).execute( AV13CliCod, AV10campo, AV9auxDescrip, AV16Descrip, true, AV58puntosSuspensivosEs, GXv_char8) ;
                        traducirmigracioncaracter.this.GXt_char3 = GXv_char8[0] ;
                        AV63auxError = GXt_char3 ;
                        /* Execute user subroutine: 'AGREGAR ERROR' */
                        S121 ();
                        if ( returnInSub )
                        {
                           returnInSub = true;
                           cleanup();
                           if (true) return;
                        }
                     }
                     else
                     {
                        GXt_char3 = AV61advertencia ;
                        GXv_char8[0] = GXt_char3 ;
                        new web.mensajeseleccionaropcionmigracionexisten(remoteHandle, context).execute( AV13CliCod, AV10campo, AV9auxDescrip, AV16Descrip, false, AV58puntosSuspensivosEs, GXv_char8) ;
                        traducirmigracioncaracter.this.GXt_char3 = GXv_char8[0] ;
                        AV61advertencia = GXt_char3 ;
                        /* Execute user subroutine: 'AGREGAR WARNING' */
                        S111 ();
                        if ( returnInSub )
                        {
                           returnInSub = true;
                           cleanup();
                           if (true) return;
                        }
                     }
                  }
                  else
                  {
                     if ( ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Actividad", "")) == 0 ) || ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Modalidad", "")) == 0 ) || ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Zona", "")) == 0 ) || ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Situacion", "")) == 0 ) || ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Condicion", "")) == 0 ) || ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Siniestrado", "")) == 0 ) || ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Convenio", "")) == 0 ) || ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Sindicato", "")) == 0 ) || ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Categoria", "")) == 0 ) || ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Parentesco", "")) == 0 ) || ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Actividad laboral AFIP", "")) == 0 ) || ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Puesto AFIP", "")) == 0 ) )
                     {
                        if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Puesto AFIP", "")) != 0 )
                        {
                           GXt_char3 = AV63auxError ;
                           GXv_char8[0] = GXt_char3 ;
                           new web.mensajesecreararegistro(remoteHandle, context).execute( AV13CliCod, AV10campo, AV16Descrip, false, AV32puedeCrear, GXv_char8) ;
                           traducirmigracioncaracter.this.GXt_char3 = GXv_char8[0] ;
                           AV63auxError = GXt_char3 ;
                           /* Execute user subroutine: 'AGREGAR ERROR' */
                           S121 ();
                           if ( returnInSub )
                           {
                              returnInSub = true;
                              cleanup();
                              if (true) return;
                           }
                        }
                     }
                     else
                     {
                        GXt_char3 = AV61advertencia ;
                        GXv_char8[0] = GXt_char3 ;
                        new web.mensajesecreararegistro(remoteHandle, context).execute( AV13CliCod, AV10campo, AV16Descrip, false, AV32puedeCrear, GXv_char8) ;
                        traducirmigracioncaracter.this.GXt_char3 = GXv_char8[0] ;
                        AV61advertencia = GXt_char3 ;
                        /* Execute user subroutine: 'AGREGAR WARNING' */
                        S111 ();
                        if ( returnInSub )
                        {
                           returnInSub = true;
                           cleanup();
                           if (true) return;
                        }
                     }
                  }
               }
               else
               {
                  AV9auxDescrip = AV16Descrip ;
                  GXt_char3 = AV61advertencia ;
                  GXv_char8[0] = GXt_char3 ;
                  new web.mensajesecreararegistro(remoteHandle, context).execute( AV13CliCod, AV10campo, AV16Descrip, false, AV32puedeCrear, GXv_char8) ;
                  traducirmigracioncaracter.this.GXt_char3 = GXv_char8[0] ;
                  AV61advertencia = GXt_char3 ;
                  /* Execute user subroutine: 'AGREGAR WARNING' */
                  S111 ();
                  if ( returnInSub )
                  {
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
                  if ( AV20grabarNuevo )
                  {
                     GXt_char3 = AV14Codigo ;
                     GXv_char8[0] = GXt_char3 ;
                     new web.getnextcodigoimportacion(remoteHandle, context).execute( AV13CliCod, AV10campo, AV38codigoDependencia, AV16Descrip, GXv_char8) ;
                     traducirmigracioncaracter.this.GXt_char3 = GXv_char8[0] ;
                     AV14Codigo = GXt_char3 ;
                     new web.msgdebug_prod(remoteHandle, context).execute( AV71Pgmname, httpContext.getMessage( "&campo \"", "")+AV10campo+httpContext.getMessage( "\" &Codigo ", "")+AV14Codigo) ;
                     if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Area", "")) == 0 )
                     {
                        new web.msgdebug_prod(remoteHandle, context).execute( AV71Pgmname, httpContext.getMessage( "alta area", "")) ;
                        /*
                           INSERT RECORD ON TABLE Seccion

                        */
                        A3CliCod = AV13CliCod ;
                        A13SecCodigo = AV14Codigo ;
                        A329SecDescrip = GXutil.trim( AV16Descrip) ;
                        GXt_char3 = A675SecDescripSinAc ;
                        GXv_char8[0] = GXt_char3 ;
                        new web.sacaracentos2(remoteHandle, context).execute( A329SecDescrip, GXv_char8) ;
                        traducirmigracioncaracter.this.GXt_char3 = GXv_char8[0] ;
                        A675SecDescripSinAc = GXt_char3 ;
                        A1984SecRelSec = 0 ;
                        A1985SecRelSecCli = 0 ;
                        A1986SecPadre = "" ;
                        A2015SecRelRef = "" ;
                        A2033SecOld = "" ;
                        /* Using cursor P00LE2 */
                        pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo, A329SecDescrip, A675SecDescripSinAc, Integer.valueOf(A1984SecRelSec), Integer.valueOf(A1985SecRelSecCli), A1986SecPadre, A2015SecRelRef, A2033SecOld});
                        Application.getSmartCacheProvider(remoteHandle).setUpdated("Seccion");
                        if ( (pr_default.getStatus(0) == 1) )
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
                     }
                     else if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Banco", "")) == 0 )
                     {
                        /*
                           INSERT RECORD ON TABLE Banco

                        */
                        A3CliCod = AV13CliCod ;
                        A7BanCod = AV14Codigo ;
                        A117BanDescrip = GXutil.trim( AV16Descrip) ;
                        GXt_char3 = A679BanDescripSinAc ;
                        GXv_char8[0] = GXt_char3 ;
                        new web.sacaracentos2(remoteHandle, context).execute( A117BanDescrip, GXv_char8) ;
                        traducirmigracioncaracter.this.GXt_char3 = GXv_char8[0] ;
                        A679BanDescripSinAc = GXt_char3 ;
                        A1978BanRelSec = 0 ;
                        A1979BanRelSecCli = 0 ;
                        A1980BancodPadre = "" ;
                        A2012BancoRelRef = "" ;
                        A2024BancoOld = "" ;
                        /* Using cursor P00LE3 */
                        pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), A7BanCod, A117BanDescrip, A679BanDescripSinAc, Integer.valueOf(A1978BanRelSec), Integer.valueOf(A1979BanRelSecCli), A1980BancodPadre, A2012BancoRelRef, A2024BancoOld});
                        Application.getSmartCacheProvider(remoteHandle).setUpdated("Banco");
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
                     }
                     else if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Obra Social", "")) == 0 )
                     {
                        /*
                           INSERT RECORD ON TABLE ObraSocial

                        */
                        A3CliCod = AV13CliCod ;
                        A5OsoCod = AV14Codigo ;
                        if ( ! AV43MigrEncontroOsoAfip )
                        {
                           GXt_char3 = A306OsoC3992 ;
                           GXv_char8[0] = GXt_char3 ;
                           new web.getmigrosafip(remoteHandle, context).execute( AV13CliCod, AV17EmpCod, AV23MigrLegNumero, GXv_char8) ;
                           traducirmigracioncaracter.this.GXt_char3 = GXv_char8[0] ;
                           A306OsoC3992 = GXt_char3 ;
                           n306OsoC3992 = false ;
                        }
                        else
                        {
                           A306OsoC3992 = GXutil.trim( AV16Descrip) ;
                           n306OsoC3992 = false ;
                        }
                        A307OsoDescrip = GXutil.trim( AV16Descrip) ;
                        if ( AV28MigrEncontroOsoSigla )
                        {
                           AV29OsoSigla = GXutil.trim( AV16Descrip) ;
                        }
                        else
                        {
                           GXt_char3 = AV29OsoSigla ;
                           GXv_char8[0] = GXt_char3 ;
                           new web.getnextsiglaos(remoteHandle, context).execute( AV13CliCod, AV16Descrip, GXv_char8) ;
                           traducirmigracioncaracter.this.GXt_char3 = GXv_char8[0] ;
                           AV29OsoSigla = GXt_char3 ;
                        }
                        AV30OsoSiglaYDesc = AV29OsoSigla ;
                        if ( ! AV28MigrEncontroOsoSigla )
                        {
                           AV30OsoSiglaYDesc += " - " + GXutil.trim( AV16Descrip) ;
                        }
                        GXt_char3 = A681OsoDescripSinAc ;
                        GXv_char8[0] = GXt_char3 ;
                        new web.sacaracentos2(remoteHandle, context).execute( A307OsoDescrip, GXv_char8) ;
                        traducirmigracioncaracter.this.GXt_char3 = GXv_char8[0] ;
                        A681OsoDescripSinAc = GXt_char3 ;
                        A1981OsoRelSec = 0 ;
                        A1982OsoRelSecCli = 0 ;
                        A1983OsoPadre = "" ;
                        A2014OsoRelRef = "" ;
                        A2035OsoOld = "" ;
                        GXt_char3 = A2160OsoActCom ;
                        GXv_char8[0] = GXt_char3 ;
                        new web.empresagetactcomercial(remoteHandle, context).execute( AV13CliCod, AV17EmpCod, GXv_char8) ;
                        traducirmigracioncaracter.this.GXt_char3 = GXv_char8[0] ;
                        A2160OsoActCom = GXt_char3 ;
                        n2160OsoActCom = false ;
                        /* Using cursor P00LE4 */
                        pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), A5OsoCod, A307OsoDescrip, Boolean.valueOf(n306OsoC3992), A306OsoC3992, A681OsoDescripSinAc, Integer.valueOf(A1981OsoRelSec), Integer.valueOf(A1982OsoRelSecCli), A1983OsoPadre, A2014OsoRelRef, A2035OsoOld, Boolean.valueOf(n2160OsoActCom), A2160OsoActCom});
                        Application.getSmartCacheProvider(remoteHandle).setUpdated("ObraSocial");
                        if ( (pr_default.getStatus(2) == 1) )
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
                     }
                     else if ( GXutil.strcmp(AV10campo, httpContext.getMessage( "Puesto", "")) == 0 )
                     {
                        GXv_char8[0] = AV54auxSinAcentos ;
                        new web.sacaracentos2(remoteHandle, context).execute( AV16Descrip, GXv_char8) ;
                        traducirmigracioncaracter.this.AV54auxSinAcentos = GXv_char8[0] ;
                        new web.newpuesto(remoteHandle, context).execute( AV13CliCod, AV53auxSecCodigo, AV14Codigo, AV16Descrip, AV54auxSinAcentos, true, 0, 0, "") ;
                     }
                  }
               }
            }
         }
      }
      if ( AV31errores.size() > 0 )
      {
         AV18error = (String)AV31errores.elementAt(-1+1) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV71Pgmname, httpContext.getMessage( "fin &auxDescrip ", "")+AV9auxDescrip) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'AGREGAR WARNING' Routine */
      returnInSub = false ;
      if ( GXutil.strSearch( AV62MigrLegWarnings, AV61advertencia, 1) == 0 )
      {
         AV27warnings.add(AV61advertencia, 0);
      }
   }

   public void S121( )
   {
      /* 'AGREGAR ERROR' Routine */
      returnInSub = false ;
      if ( GXutil.strSearch( AV64MigrLegErrores, AV63auxError, 1) == 0 )
      {
         AV31errores.add(AV63auxError, 0);
      }
   }

   protected void cleanup( )
   {
      this.aP10[0] = traducirmigracioncaracter.this.AV14Codigo;
      this.aP11[0] = traducirmigracioncaracter.this.AV31errores;
      this.aP12[0] = traducirmigracioncaracter.this.AV27warnings;
      this.aP13[0] = traducirmigracioncaracter.this.AV9auxDescrip;
      this.aP14[0] = traducirmigracioncaracter.this.AV21hayLike;
      this.aP15[0] = traducirmigracioncaracter.this.AV19existe;
      this.aP16[0] = traducirmigracioncaracter.this.AV36esCodigo;
      this.aP17[0] = traducirmigracioncaracter.this.AV18error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14Codigo = "" ;
      AV9auxDescrip = "" ;
      AV18error = "" ;
      AV8MigrLegBasico = DecimalUtil.ZERO ;
      GXt_decimal1 = DecimalUtil.ZERO ;
      GXv_decimal2 = new java.math.BigDecimal[1] ;
      AV47parmAuxDescrip = "" ;
      AV71Pgmname = "" ;
      AV52auxConveCodigo = "" ;
      AV59ZonCod = "" ;
      AV56palabras = new GXSimpleCollection<String>(String.class, "internal", "");
      AV63auxError = "" ;
      AV37aux2Descrip = "" ;
      AV51auxCatCodigo = "" ;
      AV33BanCod = "" ;
      AV65ActCodigo = "" ;
      GXv_int7 = new int[1] ;
      AV34MprCod = "" ;
      AV68auxZonCod = "" ;
      AV66palabra = "" ;
      AV39ActComCodigo = "" ;
      AV44originalDescrip = "" ;
      AV49ParDescripSinAc = "" ;
      GXv_char4 = new String[1] ;
      GXv_int5 = new short[1] ;
      AV53auxSecCodigo = "" ;
      GXv_boolean6 = new boolean[1] ;
      AV61advertencia = "" ;
      A13SecCodigo = "" ;
      A329SecDescrip = "" ;
      A675SecDescripSinAc = "" ;
      A1986SecPadre = "" ;
      A2015SecRelRef = "" ;
      A2033SecOld = "" ;
      Gx_emsg = "" ;
      A7BanCod = "" ;
      A117BanDescrip = "" ;
      A679BanDescripSinAc = "" ;
      A1980BancodPadre = "" ;
      A2012BancoRelRef = "" ;
      A2024BancoOld = "" ;
      A5OsoCod = "" ;
      A306OsoC3992 = "" ;
      A307OsoDescrip = "" ;
      AV29OsoSigla = "" ;
      AV30OsoSiglaYDesc = "" ;
      A681OsoDescripSinAc = "" ;
      A1983OsoPadre = "" ;
      A2014OsoRelRef = "" ;
      A2035OsoOld = "" ;
      A2160OsoActCom = "" ;
      GXt_char3 = "" ;
      AV54auxSinAcentos = "" ;
      GXv_char8 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.traducirmigracioncaracter__default(),
         new Object[] {
             new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      AV71Pgmname = "TraducirMigracionCaracter" ;
      /* GeneXus formulas. */
      AV71Pgmname = "TraducirMigracionCaracter" ;
      Gx_err = (short)(0) ;
   }

   private short AV17EmpCod ;
   private short AV41PaiCod ;
   private short AV15CodigoNum ;
   private short AV35CondiCodigo ;
   private short AV45busquedas ;
   private short GXv_int5[] ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV23MigrLegNumero ;
   private int AV40CliConveVer ;
   private int GXv_int7[] ;
   private int GX_INS43 ;
   private int A3CliCod ;
   private int A1984SecRelSec ;
   private int A1985SecRelSecCli ;
   private int GX_INS4 ;
   private int A1978BanRelSec ;
   private int A1979BanRelSecCli ;
   private int GX_INS37 ;
   private int A1981OsoRelSec ;
   private int A1982OsoRelSecCli ;
   private java.math.BigDecimal AV8MigrLegBasico ;
   private java.math.BigDecimal GXt_decimal1 ;
   private java.math.BigDecimal GXv_decimal2[] ;
   private String AV10campo ;
   private String AV38codigoDependencia ;
   private String AV48algoritmoEquivalenciasUsar ;
   private String AV14Codigo ;
   private String AV71Pgmname ;
   private String AV52auxConveCodigo ;
   private String AV59ZonCod ;
   private String AV51auxCatCodigo ;
   private String AV33BanCod ;
   private String AV65ActCodigo ;
   private String AV34MprCod ;
   private String AV68auxZonCod ;
   private String AV66palabra ;
   private String AV39ActComCodigo ;
   private String GXv_char4[] ;
   private String AV53auxSecCodigo ;
   private String A13SecCodigo ;
   private String A1986SecPadre ;
   private String Gx_emsg ;
   private String A7BanCod ;
   private String A1980BancodPadre ;
   private String A5OsoCod ;
   private String A306OsoC3992 ;
   private String AV29OsoSigla ;
   private String A1983OsoPadre ;
   private String A2160OsoActCom ;
   private String GXt_char3 ;
   private String GXv_char8[] ;
   private boolean AV57parmGrabarNuevo ;
   private boolean AV21hayLike ;
   private boolean AV19existe ;
   private boolean AV36esCodigo ;
   private boolean AV20grabarNuevo ;
   private boolean AV32puedeCrear ;
   private boolean returnInSub ;
   private boolean AV28MigrEncontroOsoSigla ;
   private boolean AV43MigrEncontroOsoAfip ;
   private boolean AV26seguir ;
   private boolean AV50equivalente ;
   private boolean AV55fueraConvenioEs ;
   private boolean GXv_boolean6[] ;
   private boolean AV58puntosSuspensivosEs ;
   private boolean n306OsoC3992 ;
   private boolean n2160OsoActCom ;
   private String AV64MigrLegErrores ;
   private String AV62MigrLegWarnings ;
   private String A2033SecOld ;
   private String A2024BancoOld ;
   private String A2035OsoOld ;
   private String AV16Descrip ;
   private String AV9auxDescrip ;
   private String AV18error ;
   private String AV47parmAuxDescrip ;
   private String AV63auxError ;
   private String AV37aux2Descrip ;
   private String AV44originalDescrip ;
   private String AV49ParDescripSinAc ;
   private String AV61advertencia ;
   private String A329SecDescrip ;
   private String A675SecDescripSinAc ;
   private String A2015SecRelRef ;
   private String A117BanDescrip ;
   private String A679BanDescripSinAc ;
   private String A2012BancoRelRef ;
   private String A307OsoDescrip ;
   private String AV30OsoSiglaYDesc ;
   private String A681OsoDescripSinAc ;
   private String A2014OsoRelRef ;
   private String AV54auxSinAcentos ;
   private String[] aP17 ;
   private String[] aP10 ;
   private GXSimpleCollection<String>[] aP11 ;
   private GXSimpleCollection<String>[] aP12 ;
   private String[] aP13 ;
   private boolean[] aP14 ;
   private boolean[] aP15 ;
   private boolean[] aP16 ;
   private IDataStoreProvider pr_default ;
   private GXSimpleCollection<String> AV56palabras ;
   private GXSimpleCollection<String> AV31errores ;
   private GXSimpleCollection<String> AV27warnings ;
}

final  class traducirmigracioncaracter__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P00LE2", "SAVEPOINT gxupdate;INSERT INTO Seccion(CliCod, SecCodigo, SecDescrip, SecDescripSinAc, SecRelSec, SecRelSecCli, SecPadre, SecRelRef, SecOld, SecHabilitada, SecApoOpc) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, FALSE, FALSE);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P00LE3", "SAVEPOINT gxupdate;INSERT INTO Banco(CliCod, BanCod, BanDescrip, BanDescripSinAc, BanRelSec, BanRelSecCli, BancodPadre, BancoRelRef, BancoOld, BanHabilitado, BanCUIT) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, FALSE, '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P00LE4", "SAVEPOINT gxupdate;INSERT INTO ObraSocial(CliCod, OsoCod, OsoDescrip, OsoC3992, OsoDescripSinAc, OsoRelSec, OsoRelSecCli, OsoPadre, OsoRelRef, OsoOld, OsoActCom, OsoSigla, OsoHabilitada, OsoSiglaYDesc, OsoAporteAdic) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '', FALSE, '', 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setString(7, (String)parms[6], 20);
               stmt.setVarchar(8, (String)parms[7], 40, false);
               stmt.setNLongVarchar(9, (String)parms[8], false);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 6);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setString(7, (String)parms[6], 6);
               stmt.setVarchar(8, (String)parms[7], 40, false);
               stmt.setNLongVarchar(9, (String)parms[8], false);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(4, (String)parms[4], 20);
               }
               stmt.setVarchar(5, (String)parms[5], 400, false);
               stmt.setInt(6, ((Number) parms[6]).intValue());
               stmt.setInt(7, ((Number) parms[7]).intValue());
               stmt.setString(8, (String)parms[8], 20);
               stmt.setVarchar(9, (String)parms[9], 40, false);
               stmt.setNLongVarchar(10, (String)parms[10], false);
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(11, (String)parms[12], 20);
               }
               return;
      }
   }

}

