package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class validarconcepto2 extends GXProcedure
{
   public validarconcepto2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( validarconcepto2.class ), "" );
   }

   public validarconcepto2( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             boolean aP5 ,
                             String aP6 ,
                             String aP7 ,
                             boolean aP8 ,
                             String aP9 ,
                             boolean aP10 ,
                             String aP11 ,
                             String aP12 ,
                             String aP13 ,
                             String aP14 ,
                             String aP15 ,
                             boolean aP16 ,
                             String aP17 ,
                             boolean aP18 ,
                             boolean[] aP19 ,
                             boolean[] aP20 ,
                             String[] aP21 )
   {
      validarconcepto2.this.aP22 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21, aP22);
      return aP22[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        boolean aP5 ,
                        String aP6 ,
                        String aP7 ,
                        boolean aP8 ,
                        String aP9 ,
                        boolean aP10 ,
                        String aP11 ,
                        String aP12 ,
                        String aP13 ,
                        String aP14 ,
                        String aP15 ,
                        boolean aP16 ,
                        String aP17 ,
                        boolean aP18 ,
                        boolean[] aP19 ,
                        boolean[] aP20 ,
                        String[] aP21 ,
                        String[] aP22 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21, aP22);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             boolean aP5 ,
                             String aP6 ,
                             String aP7 ,
                             boolean aP8 ,
                             String aP9 ,
                             boolean aP10 ,
                             String aP11 ,
                             String aP12 ,
                             String aP13 ,
                             String aP14 ,
                             String aP15 ,
                             boolean aP16 ,
                             String aP17 ,
                             boolean aP18 ,
                             boolean[] aP19 ,
                             boolean[] aP20 ,
                             String[] aP21 ,
                             String[] aP22 )
   {
      validarconcepto2.this.AV16CliCod = aP0;
      validarconcepto2.this.AV17EmpCod = aP1;
      validarconcepto2.this.AV37LiqNro = aP2;
      validarconcepto2.this.AV18LegNumero = aP3;
      validarconcepto2.this.AV19LiqPeriodo = aP4;
      validarconcepto2.this.AV10calcularContribuciones = aP5;
      validarconcepto2.this.AV9SubTipoConCod1 = aP6;
      validarconcepto2.this.AV25SubTipoConCod2 = aP7;
      validarconcepto2.this.AV11calcularSAC = aP8;
      validarconcepto2.this.AV12ConCodigo = aP9;
      validarconcepto2.this.AV28alcanzaGanancias = aP10;
      validarconcepto2.this.AV14ConFormula = aP11;
      validarconcepto2.this.AV15ConDescrip = aP12;
      validarconcepto2.this.AV22devoGananciasAnioAnteriorConCodigo = aP13;
      validarconcepto2.this.AV29liquidaSACConCodigo = aP14;
      validarconcepto2.this.AV30alcanzaGananciasConCodigo = aP15;
      validarconcepto2.this.AV26cargoSiradig = aP16;
      validarconcepto2.this.AV65ProcesoLiquidacion = aP17;
      validarconcepto2.this.AV66insertandoConceptos = aP18;
      validarconcepto2.this.aP19 = aP19;
      validarconcepto2.this.aP20 = aP20;
      validarconcepto2.this.aP21 = aP21;
      validarconcepto2.this.aP22 = aP22;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV103noValidoTxt = httpContext.getMessage( "El concepto no es válido para la liquidación", "") ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, httpContext.getMessage( "0 &LiqPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV19LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &calcularSAC ", "")+GXutil.trim( GXutil.booltostr( AV11calcularSAC))) ;
      /* Using cursor P012A2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV16CliCod), AV12ConCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A26ConCodigo = P012A2_A26ConCodigo[0] ;
         A3CliCod = P012A2_A3CliCod[0] ;
         A953ConCondicion = P012A2_A953ConCondicion[0] ;
         n953ConCondicion = P012A2_n953ConCondicion[0] ;
         A954ConCondCodigo = P012A2_A954ConCondCodigo[0] ;
         AV46ConCondicion = A953ConCondicion ;
         AV47ConCondCodigo = A954ConCondCodigo ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      AV8validar = true ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, httpContext.getMessage( "concodigo ", "")+GXutil.trim( AV12ConCodigo)+httpContext.getMessage( " &conceptoObligatorioEs ", "")+GXutil.trim( GXutil.booltostr( AV35conceptoObligatorioEs))) ;
      if ( ! AV35conceptoObligatorioEs )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, httpContext.getMessage( "no es obligatorio", "")) ;
         if ( GXutil.strcmp(AV46ConCondicion, "GU") == 0 )
         {
            GXv_int1[0] = AV56LegClase ;
            new web.getlegajoclase(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV18LegNumero, GXv_int1) ;
            validarconcepto2.this.AV56LegClase = GXv_int1[0] ;
            if ( AV56LegClase != 1 )
            {
               AV8validar = false ;
            }
            else
            {
               GXv_char2[0] = AV121tipo_tarifa ;
               new web.gettipodetarifa(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV37LiqNro, AV18LegNumero, (short)(0), "", "", GXv_char2) ;
               validarconcepto2.this.AV121tipo_tarifa = GXv_char2[0] ;
               if ( GXutil.strcmp(AV121tipo_tarifa, "P") != 0 )
               {
                  AV8validar = false ;
               }
               else
               {
                  GXv_char2[0] = AV89ConveCodigo ;
                  new web.empleadogetconvenio(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV18LegNumero, GXv_char2) ;
                  validarconcepto2.this.AV89ConveCodigo = GXv_char2[0] ;
                  if ( ! (GXutil.strcmp("", AV89ConveCodigo)==0) )
                  {
                     AV8validar = false ;
                  }
                  else
                  {
                     GXv_decimal3[0] = DecimalUtil.doubleToDec(0) ;
                     GXv_char2[0] = AV119tipo_sueldo ;
                     GXv_int4[0] = (short)(0) ;
                     GXv_boolean5[0] = false ;
                     new web.getlegajosueldoultimo(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV37LiqNro, AV18LegNumero, AV19LiqPeriodo, GXv_decimal3, GXv_char2, GXv_int4, GXv_boolean5) ;
                     validarconcepto2.this.AV119tipo_sueldo = GXv_char2[0] ;
                     if ( GXutil.strcmp(AV119tipo_sueldo, "GrossingUp") != 0 )
                     {
                        AV8validar = false ;
                     }
                  }
               }
            }
         }
         else if ( GXutil.strcmp(AV46ConCondicion, "B24") == 0 )
         {
            GXv_int4[0] = AV71PaiCod ;
            GXv_char2[0] = AV89ConveCodigo ;
            GXv_char6[0] = AV107LegCatCodigo ;
            new web.getconvenioycategorialegajo(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV37LiqNro, AV18LegNumero, GXv_int4, GXv_char2, GXv_char6) ;
            validarconcepto2.this.AV71PaiCod = GXv_int4[0] ;
            validarconcepto2.this.AV89ConveCodigo = GXv_char2[0] ;
            validarconcepto2.this.AV107LegCatCodigo = GXv_char6[0] ;
            if ( (GXutil.strcmp("", AV89ConveCodigo)==0) )
            {
               AV8validar = false ;
            }
            else
            {
               GXt_char7 = AV104parmValue ;
               GXt_char8 = AV104parmValue ;
               GXv_char6[0] = GXt_char8 ;
               new web.desglosaradicional_codigoparam(remoteHandle, context).execute( GXv_char6) ;
               validarconcepto2.this.GXt_char8 = GXv_char6[0] ;
               GXv_char2[0] = GXt_char7 ;
               new web.getparametro(remoteHandle, context).execute( AV16CliCod, GXt_char8, GXv_char2) ;
               validarconcepto2.this.GXt_char7 = GXv_char2[0] ;
               AV104parmValue = GXt_char7 ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, httpContext.getMessage( "parmvalue ", "")+GXutil.trim( AV104parmValue)) ;
               AV105desglozar = GXutil.boolval( AV104parmValue) ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, httpContext.getMessage( "&desglozar ", "")+GXutil.trim( GXutil.booltostr( AV105desglozar))) ;
               if ( ! AV105desglozar )
               {
                  AV8validar = false ;
               }
               else
               {
                  GXv_int9[0] = AV106CliConveVer ;
                  new web.getversiondelegajo(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV18LegNumero, GXv_int9) ;
                  validarconcepto2.this.AV106CliConveVer = GXv_int9[0] ;
                  GXv_int1[0] = AV56LegClase ;
                  new web.getlegajoclase(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV18LegNumero, GXv_int1) ;
                  validarconcepto2.this.AV56LegClase = GXv_int1[0] ;
                  GXv_int4[0] = AV125CliPaiConve ;
                  new web.getpaisdeconvenio(remoteHandle, context).execute( AV89ConveCodigo, AV71PaiCod, GXv_int4) ;
                  validarconcepto2.this.AV125CliPaiConve = GXv_int4[0] ;
                  GXv_boolean5[0] = false ;
                  GXv_char6[0] = "" ;
                  GXv_decimal3[0] = AV108CatValorHora ;
                  new web.getescalasalarialvigente3(remoteHandle, context).execute( AV106CliConveVer, AV125CliPaiConve, AV89ConveCodigo, AV107LegCatCodigo, AV19LiqPeriodo, AV56LegClase, httpContext.getMessage( "ADICIONAL", ""), GXv_boolean5, GXv_char6, GXv_decimal3) ;
                  validarconcepto2.this.AV108CatValorHora = GXv_decimal3[0] ;
                  if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV108CatValorHora)==0) )
                  {
                     AV8validar = false ;
                  }
               }
            }
         }
         else if ( GXutil.strcmp(AV46ConCondicion, "R1") == 0 )
         {
            GXv_char6[0] = AV104parmValue ;
            new web.getparametro(remoteHandle, context).execute( AV16CliCod, new web.redondeo_codigoparam(remoteHandle, context).executeUdp( ), GXv_char6) ;
            validarconcepto2.this.AV104parmValue = GXv_char6[0] ;
            GXv_int1[0] = AV114LegFormaPago ;
            new web.getlegformapago(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV18LegNumero, GXv_int1) ;
            validarconcepto2.this.AV114LegFormaPago = GXv_int1[0] ;
            if ( ( GXutil.strcmp(AV104parmValue, httpContext.getMessage( "SIEMPRE", "")) != 0 ) && ( AV114LegFormaPago == 3 ) )
            {
               AV8validar = false ;
               AV102LiqDLog = httpContext.getMessage( "Parámetro de cálculo de redondeo está en \"", "") + GXutil.trim( AV104parmValue) + httpContext.getMessage( "\" y la forma de pago es ", "") + GXutil.trim( httpContext.getMessage( web.gxdomainformadepago.getDescription(httpContext,(byte)AV114LegFormaPago), "")) ;
            }
         }
         else if ( GXutil.strcmp(AV46ConCondicion, "B16") == 0 )
         {
            GXv_int1[0] = AV56LegClase ;
            new web.getlegajoclase(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV18LegNumero, GXv_int1) ;
            validarconcepto2.this.AV56LegClase = GXv_int1[0] ;
            if ( AV56LegClase != 1 )
            {
               AV8validar = false ;
            }
            else
            {
               GXv_char6[0] = AV121tipo_tarifa ;
               new web.gettipodetarifa(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV37LiqNro, AV18LegNumero, (short)(0), "", "", GXv_char6) ;
               validarconcepto2.this.AV121tipo_tarifa = GXv_char6[0] ;
               if ( GXutil.strcmp(AV121tipo_tarifa, "P") != 0 )
               {
                  AV8validar = false ;
               }
               else
               {
                  if ( ! (0==AV37LiqNro) )
                  {
                     GXv_decimal3[0] = DecimalUtil.doubleToDec(0) ;
                     GXv_decimal10[0] = DecimalUtil.doubleToDec(0) ;
                     GXv_boolean5[0] = AV52existe ;
                     GXv_int1[0] = (byte)(0) ;
                     new web.getliqdimpcalcuporperiodo(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV37LiqNro, 0, AV19LiqPeriodo, AV18LegNumero, AV12ConCodigo, AV65ProcesoLiquidacion, false, false, GXv_decimal3, GXv_decimal10, GXv_boolean5, GXv_int1) ;
                     validarconcepto2.this.AV52existe = GXv_boolean5[0] ;
                     if ( AV52existe )
                     {
                        AV8validar = false ;
                     }
                  }
               }
            }
         }
         else if ( GXutil.strcmp(AV46ConCondicion, "N01") == 0 )
         {
            AV8validar = false ;
         }
         else if ( GXutil.strcmp(AV46ConCondicion, "B15") == 0 )
         {
            AV130GXLvl113 = (byte)(0) ;
            /* Using cursor P012A3 */
            pr_default.execute(1, new Object[] {Integer.valueOf(AV16CliCod), Short.valueOf(AV17EmpCod), Integer.valueOf(AV18LegNumero)});
            while ( (pr_default.getStatus(1) != 101) )
            {
               A1547GuarCod = P012A3_A1547GuarCod[0] ;
               n1547GuarCod = P012A3_n1547GuarCod[0] ;
               A6LegNumero = P012A3_A6LegNumero[0] ;
               A1EmpCod = P012A3_A1EmpCod[0] ;
               A3CliCod = P012A3_A3CliCod[0] ;
               A29LegOrden = P012A3_A29LegOrden[0] ;
               AV130GXLvl113 = (byte)(1) ;
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
               pr_default.readNext(1);
            }
            pr_default.close(1);
            if ( AV130GXLvl113 == 0 )
            {
               AV8validar = false ;
            }
         }
         else if ( GXutil.strcmp(AV46ConCondicion, "B14") == 0 )
         {
            AV38LegDedConCodigo = AV47ConCondCodigo ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, httpContext.getMessage( "es reintegro &LegDedConCodigo ", "")+GXutil.trim( AV38LegDedConCodigo)) ;
            if ( ! (GXutil.strcmp("", AV38LegDedConCodigo)==0) )
            {
               GXv_decimal10[0] = AV36LegDedImporte ;
               GXv_boolean5[0] = AV94dedExiste ;
               new web.obtenerimportededucciondeperiodo(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV18LegNumero, AV19LiqPeriodo, AV38LegDedConCodigo, "reintegro", AV91operandos, true, GXv_decimal10, GXv_boolean5) ;
               validarconcepto2.this.AV36LegDedImporte = GXv_decimal10[0] ;
               validarconcepto2.this.AV94dedExiste = GXv_boolean5[0] ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, httpContext.getMessage( "&LegDedImporte ", "")+GXutil.trim( GXutil.str( AV36LegDedImporte, 14, 2))+httpContext.getMessage( " dedexiste ", "")+GXutil.trim( GXutil.booltostr( AV94dedExiste))) ;
               if ( ! AV94dedExiste )
               {
                  AV8validar = false ;
               }
            }
         }
         else if ( GXutil.strcmp(AV46ConCondicion, "B12") == 0 )
         {
            AV8validar = false ;
            GXv_decimal10[0] = AV85EmpAntiguedad ;
            new web.getantiguedadporempresa(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, GXv_decimal10) ;
            validarconcepto2.this.AV85EmpAntiguedad = GXv_decimal10[0] ;
            if ( AV85EmpAntiguedad.doubleValue() != 0 )
            {
               AV8validar = true ;
            }
            else
            {
               GXv_char6[0] = AV89ConveCodigo ;
               new web.empleadogetconvenio(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV18LegNumero, GXv_char6) ;
               validarconcepto2.this.AV89ConveCodigo = GXv_char6[0] ;
               if ( ! (GXutil.strcmp("", AV89ConveCodigo)==0) )
               {
                  AV92palabra = "antiguedad" ;
                  GXv_decimal10[0] = AV87Importe ;
                  GXv_char6[0] = "" ;
                  new web.conveniogetadicional2(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV37LiqNro, AV18LegNumero, AV19LiqPeriodo, AV12ConCodigo, AV92palabra, "", AV65ProcesoLiquidacion, GXv_decimal10, GXv_char6) ;
                  validarconcepto2.this.AV87Importe = GXv_decimal10[0] ;
                  if ( AV87Importe.doubleValue() != 0 )
                  {
                     AV8validar = true ;
                  }
               }
            }
         }
         else if ( GXutil.strcmp(AV46ConCondicion, "B13") == 0 )
         {
            AV8validar = false ;
            GXv_decimal10[0] = AV88EmpPresentismo ;
            new web.getpresentismoporempresa(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, GXv_decimal10) ;
            validarconcepto2.this.AV88EmpPresentismo = GXv_decimal10[0] ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, httpContext.getMessage( "&EmpPresentismo ", "")+GXutil.trim( GXutil.str( AV88EmpPresentismo, 14, 4))) ;
            if ( AV88EmpPresentismo.doubleValue() != 0 )
            {
               new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, httpContext.getMessage( "&validar = true", "")) ;
               AV8validar = true ;
            }
            else
            {
               GXv_char6[0] = AV89ConveCodigo ;
               new web.empleadogetconvenio(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV18LegNumero, GXv_char6) ;
               validarconcepto2.this.AV89ConveCodigo = GXv_char6[0] ;
               if ( ! (GXutil.strcmp("", AV89ConveCodigo)==0) )
               {
                  AV92palabra = "asistencia" ;
                  GXv_decimal10[0] = AV87Importe ;
                  GXv_char6[0] = "" ;
                  new web.conveniogetadicional2(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV37LiqNro, AV18LegNumero, AV19LiqPeriodo, AV12ConCodigo, AV92palabra, "", AV65ProcesoLiquidacion, GXv_decimal10, GXv_char6) ;
                  validarconcepto2.this.AV87Importe = GXv_decimal10[0] ;
                  if ( AV87Importe.doubleValue() != 0 )
                  {
                     AV8validar = true ;
                  }
               }
            }
         }
         else if ( GXutil.strcmp(AV46ConCondicion, "B9") == 0 )
         {
            GXv_boolean5[0] = AV83manejaFondoCese ;
            GXv_boolean11[0] = false ;
            GXv_char6[0] = "" ;
            new web.getmanejafondocese(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV18LegNumero, AV19LiqPeriodo, GXv_boolean5, GXv_boolean11, GXv_char6) ;
            validarconcepto2.this.AV83manejaFondoCese = GXv_boolean5[0] ;
            if ( AV83manejaFondoCese )
            {
               AV8validar = false ;
            }
         }
         else if ( GXutil.strcmp(AV46ConCondicion, "B11") == 0 )
         {
            AV8validar = false ;
            GXv_decimal10[0] = AV50LiqDImpCalcu ;
            GXv_boolean11[0] = AV52existe ;
            GXv_int1[0] = AV93LiqDCalculado ;
            new web.getliqdimpcalcu(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV37LiqNro, AV18LegNumero, AV29liquidaSACConCodigo, AV65ProcesoLiquidacion, AV66insertandoConceptos, GXv_decimal10, GXv_boolean11, GXv_int1) ;
            validarconcepto2.this.AV50LiqDImpCalcu = GXv_decimal10[0] ;
            validarconcepto2.this.AV52existe = GXv_boolean11[0] ;
            validarconcepto2.this.AV93LiqDCalculado = GXv_int1[0] ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, httpContext.getMessage( "&liquidaSACConCodigo ", "")+GXutil.trim( AV29liquidaSACConCodigo)+httpContext.getMessage( " &LiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV50LiqDImpCalcu, 14, 2))+httpContext.getMessage( " &LiqDCalculado ", "")+GXutil.trim( GXutil.str( AV93LiqDCalculado, 1, 0))+httpContext.getMessage( " &existe ", "")+GXutil.trim( GXutil.booltostr( AV52existe))) ;
            if ( ( AV50LiqDImpCalcu.doubleValue() > 0 ) || ( AV93LiqDCalculado == 0 ) )
            {
               AV8validar = true ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, httpContext.getMessage( "valllid", "")) ;
            }
            if ( ! AV8validar )
            {
               GXv_boolean11[0] = AV13LegAgenReten ;
               new web.getlegagenreten(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV18LegNumero, GXv_boolean11) ;
               validarconcepto2.this.AV13LegAgenReten = GXv_boolean11[0] ;
               if ( AV13LegAgenReten )
               {
                  GXv_decimal10[0] = AV50LiqDImpCalcu ;
                  GXv_boolean11[0] = AV52existe ;
                  GXv_int1[0] = AV93LiqDCalculado ;
                  new web.getliqdimpcalcu(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV37LiqNro, AV18LegNumero, AV30alcanzaGananciasConCodigo, AV65ProcesoLiquidacion, AV66insertandoConceptos, GXv_decimal10, GXv_boolean11, GXv_int1) ;
                  validarconcepto2.this.AV50LiqDImpCalcu = GXv_decimal10[0] ;
                  validarconcepto2.this.AV52existe = GXv_boolean11[0] ;
                  validarconcepto2.this.AV93LiqDCalculado = GXv_int1[0] ;
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, httpContext.getMessage( "&&alcanzaGananciasConCodigo ", "")+GXutil.trim( AV30alcanzaGananciasConCodigo)+httpContext.getMessage( " &LiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV50LiqDImpCalcu, 14, 2))+httpContext.getMessage( " &LiqDCalculado ", "")+GXutil.trim( GXutil.str( AV93LiqDCalculado, 1, 0))+httpContext.getMessage( " &existe ", "")+GXutil.trim( GXutil.booltostr( AV52existe))) ;
                  if ( ( AV50LiqDImpCalcu.doubleValue() > 0 ) || ( AV93LiqDCalculado == 0 ) )
                  {
                     AV8validar = true ;
                  }
               }
            }
         }
         else if ( GXutil.strcmp(AV46ConCondicion, "A13") == 0 )
         {
            GXv_boolean11[0] = AV8validar ;
            new web.getlegagenreten(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV18LegNumero, GXv_boolean11) ;
            validarconcepto2.this.AV8validar = GXv_boolean11[0] ;
         }
         else if ( GXutil.strcmp(AV46ConCondicion, "A14") == 0 )
         {
            GXv_boolean11[0] = AV13LegAgenReten ;
            new web.getlegagenreten(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV18LegNumero, GXv_boolean11) ;
            validarconcepto2.this.AV13LegAgenReten = GXv_boolean11[0] ;
            if ( ! AV13LegAgenReten )
            {
               AV8validar = false ;
            }
            else
            {
               GXv_decimal10[0] = AV50LiqDImpCalcu ;
               GXv_boolean11[0] = false ;
               GXv_int1[0] = AV113auxLiqDCalculado ;
               new web.getliqdimpcalcu(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV37LiqNro, AV18LegNumero, AV30alcanzaGananciasConCodigo, AV65ProcesoLiquidacion, AV66insertandoConceptos, GXv_decimal10, GXv_boolean11, GXv_int1) ;
               validarconcepto2.this.AV50LiqDImpCalcu = GXv_decimal10[0] ;
               validarconcepto2.this.AV113auxLiqDCalculado = GXv_int1[0] ;
               if ( ( AV50LiqDImpCalcu.doubleValue() == 0 ) && ( AV113auxLiqDCalculado != 0 ) )
               {
                  AV8validar = false ;
               }
            }
         }
         else if ( GXutil.strcmp(AV46ConCondicion, "B7") == 0 )
         {
            GXv_int1[0] = AV56LegClase ;
            GXv_char6[0] = AV120LegModTra ;
            new web.getlegajoclaseymodtra(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV18LegNumero, GXv_int1, GXv_char6) ;
            validarconcepto2.this.AV56LegClase = GXv_int1[0] ;
            validarconcepto2.this.AV120LegModTra = GXv_char6[0] ;
            if ( ( AV56LegClase == 1 ) && ( GXutil.strcmp(AV120LegModTra, "E") == 0 ) )
            {
               GXv_char6[0] = AV61TLiqCod ;
               new web.gettipoliq(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV37LiqNro, GXv_char6) ;
               validarconcepto2.this.AV61TLiqCod = GXv_char6[0] ;
               GXv_date12[0] = AV77iniPeriodo ;
               GXv_date13[0] = AV78finPeriodo ;
               new web.getrangoperiodos(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV37LiqNro, AV18LegNumero, AV61TLiqCod, AV56LegClase, AV19LiqPeriodo, false, GXv_date12, GXv_date13) ;
               validarconcepto2.this.AV77iniPeriodo = GXv_date12[0] ;
               validarconcepto2.this.AV78finPeriodo = GXv_date13[0] ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, httpContext.getMessage( "concodigo ", "")+GXutil.trim( AV12ConCodigo)+httpContext.getMessage( " haysingoce", "")) ;
               GXv_char6[0] = "" ;
               GXv_int4[0] = AV20LegLicCntDias ;
               GXv_date13[0] = AV21date ;
               GXv_date12[0] = AV21date ;
               GXv_date14[0] = AV21date ;
               GXv_decimal10[0] = DecimalUtil.doubleToDec(0) ;
               GXv_boolean11[0] = false ;
               GXv_char2[0] = AV80auxLiqDLog ;
               new web.legajodevuelvelicencia2(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV18LegNumero, AV37LiqNro, true, AV77iniPeriodo, false, AV78finPeriodo, "", false, false, false, GXv_char6, GXv_int4, GXv_date13, GXv_date12, GXv_date14, GXv_decimal10, GXv_boolean11, GXv_char2) ;
               validarconcepto2.this.AV20LegLicCntDias = GXv_int4[0] ;
               validarconcepto2.this.AV21date = GXv_date13[0] ;
               validarconcepto2.this.AV21date = GXv_date12[0] ;
               validarconcepto2.this.AV21date = GXv_date14[0] ;
               validarconcepto2.this.AV80auxLiqDLog = GXv_char2[0] ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, httpContext.getMessage( "concodigo ", "")+GXutil.trim( AV12ConCodigo)+httpContext.getMessage( " haysingoce &LegLicCntDias ", "")+GXutil.trim( GXutil.str( AV20LegLicCntDias, 4, 0))) ;
            }
            if ( AV20LegLicCntDias == 0 )
            {
               AV8validar = false ;
            }
            else
            {
               GXv_boolean11[0] = AV52existe ;
               new web.excluirporyaliquidado(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV37LiqNro, AV18LegNumero, AV19LiqPeriodo, AV65ProcesoLiquidacion, "B7", GXv_boolean11) ;
               validarconcepto2.this.AV52existe = GXv_boolean11[0] ;
               if ( AV52existe )
               {
                  AV8validar = false ;
               }
            }
            /* Execute user subroutine: 'VALIDAR YA LIQUIDADO' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV46ConCondicion, "AI") == 0 )
         {
            GXv_int1[0] = AV56LegClase ;
            GXv_char6[0] = AV120LegModTra ;
            new web.getlegajoclaseymodtra(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV18LegNumero, GXv_int1, GXv_char6) ;
            validarconcepto2.this.AV56LegClase = GXv_int1[0] ;
            validarconcepto2.this.AV120LegModTra = GXv_char6[0] ;
            if ( ( AV56LegClase == 1 ) && ( GXutil.strcmp(AV120LegModTra, "E") == 0 ) )
            {
               GXv_char6[0] = AV61TLiqCod ;
               new web.gettipoliq(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV37LiqNro, GXv_char6) ;
               validarconcepto2.this.AV61TLiqCod = GXv_char6[0] ;
               GXv_date14[0] = AV77iniPeriodo ;
               GXv_date13[0] = AV78finPeriodo ;
               new web.getrangoperiodos(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV37LiqNro, AV18LegNumero, AV61TLiqCod, AV56LegClase, AV19LiqPeriodo, false, GXv_date14, GXv_date13) ;
               validarconcepto2.this.AV77iniPeriodo = GXv_date14[0] ;
               validarconcepto2.this.AV78finPeriodo = GXv_date13[0] ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, httpContext.getMessage( "concodigo ", "")+GXutil.trim( AV12ConCodigo)+httpContext.getMessage( " haysingoce", "")) ;
               GXv_char6[0] = "" ;
               GXv_int4[0] = AV20LegLicCntDias ;
               GXv_date14[0] = AV21date ;
               GXv_date13[0] = AV21date ;
               GXv_date12[0] = AV21date ;
               GXv_decimal10[0] = DecimalUtil.doubleToDec(0) ;
               GXv_boolean11[0] = false ;
               GXv_char2[0] = AV80auxLiqDLog ;
               new web.legajodevuelvelicencia2(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV18LegNumero, AV37LiqNro, true, AV77iniPeriodo, false, AV78finPeriodo, new web.estadoausenciasinjustificadas(remoteHandle, context).executeUdp( AV16CliCod), false, false, false, GXv_char6, GXv_int4, GXv_date14, GXv_date13, GXv_date12, GXv_decimal10, GXv_boolean11, GXv_char2) ;
               validarconcepto2.this.AV20LegLicCntDias = GXv_int4[0] ;
               validarconcepto2.this.AV21date = GXv_date14[0] ;
               validarconcepto2.this.AV21date = GXv_date13[0] ;
               validarconcepto2.this.AV21date = GXv_date12[0] ;
               validarconcepto2.this.AV80auxLiqDLog = GXv_char2[0] ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, httpContext.getMessage( "concodigo ", "")+GXutil.trim( AV12ConCodigo)+httpContext.getMessage( " haysingoce &LegLicCntDias ", "")+GXutil.trim( GXutil.str( AV20LegLicCntDias, 4, 0))) ;
            }
            if ( AV20LegLicCntDias == 0 )
            {
               AV8validar = false ;
            }
            /* Execute user subroutine: 'VALIDAR YA LIQUIDADO' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( ( GXutil.strcmp(AV46ConCondicion, "B5") == 0 ) || ( GXutil.strcmp(AV46ConCondicion, "B6") == 0 ) || ( GXutil.strcmp(AV46ConCondicion, "B21") == 0 ) || ( GXutil.strcmp(AV46ConCondicion, "B22") == 0 ) )
         {
            GXv_int1[0] = AV56LegClase ;
            GXv_char6[0] = AV120LegModTra ;
            new web.getlegajoclaseymodtra(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV18LegNumero, GXv_int1, GXv_char6) ;
            validarconcepto2.this.AV56LegClase = GXv_int1[0] ;
            validarconcepto2.this.AV120LegModTra = GXv_char6[0] ;
            GXv_boolean11[0] = AV90EmpLiqFer ;
            new web.getempliqfer(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV37LiqNro, AV18LegNumero, AV56LegClase, AV120LegModTra, GXv_boolean11) ;
            validarconcepto2.this.AV90EmpLiqFer = GXv_boolean11[0] ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, httpContext.getMessage( "&EmpLiqFer ", "")+GXutil.trim( GXutil.booltostr( AV90EmpLiqFer))) ;
            if ( ! AV90EmpLiqFer || ( GXutil.strcmp(AV120LegModTra, "E") != 0 ) )
            {
               AV8validar = false ;
               if ( GXutil.strcmp(AV120LegModTra, "E") != 0 )
               {
                  AV102LiqDLog = GXutil.trim( AV103noValidoTxt) + httpContext.getMessage( " porque el trabajador no es empleado en relación de dependencia", "") ;
               }
               else
               {
                  AV102LiqDLog = GXutil.trim( AV103noValidoTxt) + httpContext.getMessage( " porque la empresa está configurada para no exponer feriados en legajos de clase ", "") + GXutil.trim( httpContext.getMessage( web.gxdomainclaseleg.getDescription(httpContext,(byte)AV56LegClase), "")) + httpContext.getMessage( ", y esto no es compatible con la condición \"", "") + GXutil.trim( httpContext.getMessage( web.gxdomaincondicionliquidacion.getDescription(httpContext,(String)AV46ConCondicion), "")) + "\"" ;
               }
            }
            else
            {
               GXv_int1[0] = AV97EmpTipoExp ;
               new web.getemptipoexp(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, GXv_int1) ;
               validarconcepto2.this.AV97EmpTipoExp = GXv_int1[0] ;
               if ( ( GXutil.strcmp(AV46ConCondicion, "B21") == 0 ) || ( GXutil.strcmp(AV46ConCondicion, "B22") == 0 ) )
               {
                  if ( ( AV97EmpTipoExp == 1 ) || ( AV56LegClase != 1 ) || ( GXutil.strcmp(AV120LegModTra, "E") != 0 ) )
                  {
                     AV8validar = false ;
                     if ( AV97EmpTipoExp == 1 )
                     {
                        AV102LiqDLog = GXutil.trim( AV103noValidoTxt) + httpContext.getMessage( " porque la empresa está configurada para prorratear el sueldo, y esto no es compatible con la condición \"", "") + GXutil.trim( httpContext.getMessage( web.gxdomaincondicionliquidacion.getDescription(httpContext,(String)AV46ConCondicion), "")) + "\"" ;
                     }
                     else
                     {
                        AV102LiqDLog = GXutil.trim( AV103noValidoTxt) + httpContext.getMessage( " porque el legajo no es empleado mensualizado, y esto no es compatible con la condición \"", "") + GXutil.trim( httpContext.getMessage( web.gxdomaincondicionliquidacion.getDescription(httpContext,(String)AV46ConCondicion), "")) + "\"" ;
                     }
                  }
                  else
                  {
                     GXv_char6[0] = AV121tipo_tarifa ;
                     new web.gettipodetarifa(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV37LiqNro, AV18LegNumero, (short)(0), "", "", GXv_char6) ;
                     validarconcepto2.this.AV121tipo_tarifa = GXv_char6[0] ;
                     if ( GXutil.strcmp(AV121tipo_tarifa, "P") != 0 )
                     {
                        AV8validar = false ;
                        AV102LiqDLog = GXutil.trim( AV103noValidoTxt) + httpContext.getMessage( " porque el legajo tiene tipo de tarifa \"por hora\"", "") ;
                     }
                  }
               }
               if ( AV8validar )
               {
                  if ( ( GXutil.strcmp(AV46ConCondicion, "B5") == 0 ) || ( GXutil.strcmp(AV46ConCondicion, "B21") == 0 ) )
                  {
                     AV84tipo_feriado = "inamovible" ;
                     GXt_char8 = AV99codigo1Palabra ;
                     GXv_char6[0] = GXt_char8 ;
                     new web.palabracod1feriadoobligatorio(remoteHandle, context).execute( AV16CliCod, GXv_char6) ;
                     validarconcepto2.this.GXt_char8 = GXv_char6[0] ;
                     AV99codigo1Palabra = GXt_char8 ;
                  }
                  else
                  {
                     AV84tipo_feriado = "nolaborable" ;
                     GXt_char8 = AV99codigo1Palabra ;
                     GXv_char6[0] = GXt_char8 ;
                     new web.palabracod1nolaborableopcional(remoteHandle, context).execute( AV16CliCod, GXv_char6) ;
                     validarconcepto2.this.GXt_char8 = GXv_char6[0] ;
                     AV99codigo1Palabra = GXt_char8 ;
                  }
                  GXv_char6[0] = AV61TLiqCod ;
                  new web.gettipoliq(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV37LiqNro, GXv_char6) ;
                  validarconcepto2.this.AV61TLiqCod = GXv_char6[0] ;
                  GXv_boolean11[0] = AV8validar ;
                  GXv_boolean5[0] = false ;
                  new web.hayferiadoenperiodo(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV61TLiqCod, AV18LegNumero, AV19LiqPeriodo, AV84tipo_feriado, false, GXv_boolean11, GXv_boolean5) ;
                  validarconcepto2.this.AV8validar = GXv_boolean11[0] ;
                  if ( ! AV8validar )
                  {
                     AV102LiqDLog = GXutil.trim( AV103noValidoTxt) + httpContext.getMessage( " porque no hay feriado ", "") + GXutil.trim( AV99codigo1Palabra) + httpContext.getMessage( " en el periodo liquidado", "") ;
                  }
               }
               new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, httpContext.getMessage( "&tipo_feriado ", "")+GXutil.trim( AV84tipo_feriado)+httpContext.getMessage( " &validar ", "")+GXutil.trim( GXutil.booltostr( AV8validar))) ;
            }
            /* Execute user subroutine: 'VALIDAR YA LIQUIDADO' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV46ConCondicion, "MI") == 0 )
         {
            GXv_int1[0] = AV97EmpTipoExp ;
            new web.getemptipoexp(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, GXv_int1) ;
            validarconcepto2.this.AV97EmpTipoExp = GXv_int1[0] ;
            GXv_int1[0] = AV56LegClase ;
            GXv_char6[0] = AV120LegModTra ;
            new web.getlegajoclaseymodtra(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV18LegNumero, GXv_int1, GXv_char6) ;
            validarconcepto2.this.AV56LegClase = GXv_int1[0] ;
            validarconcepto2.this.AV120LegModTra = GXv_char6[0] ;
            if ( ( AV97EmpTipoExp == 1 ) || ( AV56LegClase != 1 ) || ( GXutil.strcmp(AV120LegModTra, "E") != 0 ) )
            {
               AV8validar = false ;
            }
            else
            {
               GXv_char6[0] = AV121tipo_tarifa ;
               new web.gettipodetarifa(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV37LiqNro, AV18LegNumero, (short)(0), "", "", GXv_char6) ;
               validarconcepto2.this.AV121tipo_tarifa = GXv_char6[0] ;
               if ( GXutil.strcmp(AV121tipo_tarifa, "P") != 0 )
               {
                  AV8validar = false ;
               }
               else
               {
                  GXv_date14[0] = AV116LegFecIngreso ;
                  GXv_date13[0] = AV117LegFecEgreso ;
                  new web.getfecingresoyegreso(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV18LegNumero, GXv_date14, GXv_date13) ;
                  validarconcepto2.this.AV116LegFecIngreso = GXv_date14[0] ;
                  validarconcepto2.this.AV117LegFecEgreso = GXv_date13[0] ;
                  if ( ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV117LegFecEgreso)) || GXutil.dateCompare(GXutil.resetTime(AV117LegFecEgreso), GXutil.resetTime(GXutil.eomdate( AV117LegFecEgreso))) ) && ( ( GXutil.day( AV116LegFecIngreso) == 1 ) || GXutil.resetTime(AV116LegFecIngreso).before( GXutil.resetTime( AV19LiqPeriodo )) ) )
                  {
                     AV8validar = false ;
                  }
               }
            }
            /* Execute user subroutine: 'VALIDAR YA LIQUIDADO' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( ( GXutil.strcmp(AV46ConCondicion, "B4") == 0 ) || ( GXutil.strcmp(AV46ConCondicion, "VP") == 0 ) )
         {
            GXv_int1[0] = AV97EmpTipoExp ;
            new web.getemptipoexp(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, GXv_int1) ;
            validarconcepto2.this.AV97EmpTipoExp = GXv_int1[0] ;
            GXv_int1[0] = AV56LegClase ;
            GXv_char6[0] = AV120LegModTra ;
            new web.getlegajoclaseymodtra(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV18LegNumero, GXv_int1, GXv_char6) ;
            validarconcepto2.this.AV56LegClase = GXv_int1[0] ;
            validarconcepto2.this.AV120LegModTra = GXv_char6[0] ;
            if ( ( AV97EmpTipoExp == 2 ) || ( AV56LegClase != 1 ) || ( GXutil.strcmp(AV120LegModTra, "E") != 0 ) )
            {
               AV8validar = false ;
            }
            else
            {
               GXv_boolean11[0] = AV90EmpLiqFer ;
               new web.getempliqfer(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV37LiqNro, AV18LegNumero, AV56LegClase, AV120LegModTra, GXv_boolean11) ;
               validarconcepto2.this.AV90EmpLiqFer = GXv_boolean11[0] ;
               GXv_char6[0] = AV61TLiqCod ;
               new web.gettipoliq(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV37LiqNro, GXv_char6) ;
               validarconcepto2.this.AV61TLiqCod = GXv_char6[0] ;
               GXv_date14[0] = AV77iniPeriodo ;
               GXv_date13[0] = AV78finPeriodo ;
               new web.getrangoperiodos(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV37LiqNro, AV18LegNumero, AV61TLiqCod, AV56LegClase, AV19LiqPeriodo, false, GXv_date14, GXv_date13) ;
               validarconcepto2.this.AV77iniPeriodo = GXv_date14[0] ;
               validarconcepto2.this.AV78finPeriodo = GXv_date13[0] ;
               GXv_char6[0] = "" ;
               GXv_int4[0] = AV20LegLicCntDias ;
               GXv_date14[0] = AV21date ;
               GXv_date13[0] = AV21date ;
               GXv_date12[0] = AV21date ;
               GXv_decimal10[0] = DecimalUtil.doubleToDec(0) ;
               GXv_boolean11[0] = false ;
               GXv_char2[0] = "" ;
               new web.legajodevuelvelicencia2(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV18LegNumero, AV37LiqNro, true, AV77iniPeriodo, true, AV78finPeriodo, AV47ConCondCodigo, false, true, true, GXv_char6, GXv_int4, GXv_date14, GXv_date13, GXv_date12, GXv_decimal10, GXv_boolean11, GXv_char2) ;
               validarconcepto2.this.AV20LegLicCntDias = GXv_int4[0] ;
               validarconcepto2.this.AV21date = GXv_date14[0] ;
               validarconcepto2.this.AV21date = GXv_date13[0] ;
               validarconcepto2.this.AV21date = GXv_date12[0] ;
               GXt_char8 = AV96ferTrabConCodigo ;
               GXt_char7 = AV96ferTrabConCodigo ;
               GXv_char6[0] = GXt_char7 ;
               new web.feriadostrabajados_codigoparam(remoteHandle, context).execute( GXv_char6) ;
               validarconcepto2.this.GXt_char7 = GXv_char6[0] ;
               GXv_char2[0] = GXt_char8 ;
               new web.getparametro(remoteHandle, context).execute( AV16CliCod, GXt_char7, GXv_char2) ;
               validarconcepto2.this.GXt_char8 = GXv_char2[0] ;
               AV96ferTrabConCodigo = GXt_char8 ;
               GXv_decimal10[0] = DecimalUtil.doubleToDec(0) ;
               GXv_boolean11[0] = AV75hay ;
               GXv_int1[0] = (byte)(0) ;
               new web.getliqdimpcalcu(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV37LiqNro, AV18LegNumero, AV96ferTrabConCodigo, AV65ProcesoLiquidacion, false, GXv_decimal10, GXv_boolean11, GXv_int1) ;
               validarconcepto2.this.AV75hay = GXv_boolean11[0] ;
               if ( ! AV75hay )
               {
                  if ( ! AV90EmpLiqFer )
                  {
                     AV75hay = false ;
                  }
                  else
                  {
                     AV84tipo_feriado = "" ;
                     GXv_boolean11[0] = false ;
                     GXv_boolean5[0] = AV75hay ;
                     new web.hayferiadoenperiodo(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV61TLiqCod, AV18LegNumero, AV19LiqPeriodo, AV84tipo_feriado, true, GXv_boolean11, GXv_boolean5) ;
                     validarconcepto2.this.AV75hay = GXv_boolean5[0] ;
                  }
               }
               new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, httpContext.getMessage( "&LegLicCntDias ", "")+GXutil.trim( GXutil.str( AV20LegLicCntDias, 4, 0))+httpContext.getMessage( " hay ", "")+GXutil.trim( GXutil.booltostr( AV75hay))) ;
               if ( ( AV20LegLicCntDias == 0 ) && ! AV75hay )
               {
                  AV8validar = false ;
               }
            }
         }
         else if ( GXutil.strcmp(AV46ConCondicion, "B3") == 0 )
         {
            GXt_int15 = AV71PaiCod ;
            GXv_int4[0] = GXt_int15 ;
            new web.clientegetpais(remoteHandle, context).execute( AV16CliCod, GXv_int4) ;
            validarconcepto2.this.GXt_int15 = GXv_int4[0] ;
            AV71PaiCod = GXt_int15 ;
            GXv_char6[0] = AV73busca2Palabra ;
            GXv_char2[0] = "" ;
            GXv_char16[0] = "" ;
            GXv_char17[0] = "" ;
            new web.legoperandogetvalores(remoteHandle, context).execute( AV14ConFormula, GXv_char6, GXv_char2, GXv_char16, GXv_char17) ;
            validarconcepto2.this.AV73busca2Palabra = GXv_char6[0] ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, httpContext.getMessage( "conformula ", "")+AV14ConFormula+httpContext.getMessage( " buscapalabra ", "")+AV73busca2Palabra+httpContext.getMessage( " paicod ", "")+GXutil.trim( GXutil.str( AV71PaiCod, 4, 0))) ;
            GXv_int4[0] = AV70TipoOblSec ;
            GXv_boolean11[0] = false ;
            GXv_int1[0] = AV74tipo_total_embargo ;
            GXv_int18[0] = (short)(0) ;
            GXv_char17[0] = "" ;
            GXv_int19[0] = (byte)(0) ;
            new web.gettipooblsecporcodigo(remoteHandle, context).execute( AV71PaiCod, AV73busca2Palabra, GXv_int4, GXv_boolean11, GXv_int1, GXv_int18, GXv_char17, GXv_int19) ;
            validarconcepto2.this.AV70TipoOblSec = GXv_int4[0] ;
            validarconcepto2.this.AV74tipo_total_embargo = GXv_int1[0] ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, httpContext.getMessage( "&TipoOblSec ", "")+GXutil.trim( GXutil.str( AV70TipoOblSec, 4, 0))) ;
            GXv_boolean11[0] = AV8validar ;
            new web.tieneobligacionactiva(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV18LegNumero, AV70TipoOblSec, AV12ConCodigo, GXv_boolean11) ;
            validarconcepto2.this.AV8validar = GXv_boolean11[0] ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, httpContext.getMessage( "&validar ", "")+GXutil.trim( GXutil.booltostr( AV8validar))) ;
         }
         else if ( GXutil.strcmp(AV46ConCondicion, "A12") == 0 )
         {
            GXv_decimal10[0] = AV69OsoAporteAdic ;
            new web.aporteadicionalos(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV18LegNumero, GXv_decimal10) ;
            validarconcepto2.this.AV69OsoAporteAdic = GXv_decimal10[0] ;
            if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV69OsoAporteAdic)==0) )
            {
               AV8validar = false ;
            }
         }
         else if ( GXutil.strcmp(AV46ConCondicion, "A9") == 0 )
         {
            GXt_boolean20 = AV8validar ;
            GXv_boolean11[0] = GXt_boolean20 ;
            new web.tienefamiliaradherente(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV18LegNumero, GXv_boolean11) ;
            validarconcepto2.this.GXt_boolean20 = GXv_boolean11[0] ;
            AV8validar = GXt_boolean20 ;
         }
         else if ( GXutil.strcmp(AV46ConCondicion, "A10") == 0 )
         {
            GXv_char17[0] = AV67SinCod ;
            new web.empleadogetsindicato(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV18LegNumero, GXv_char17) ;
            validarconcepto2.this.AV67SinCod = GXv_char17[0] ;
            if ( (GXutil.strcmp("", AV67SinCod)==0) )
            {
               AV8validar = false ;
            }
         }
         else if ( GXutil.strcmp(AV46ConCondicion, "A11") == 0 )
         {
            AV112parcialEs = false ;
            GXt_char8 = AV109auxConCodigo ;
            GXt_char7 = AV109auxConCodigo ;
            GXv_char17[0] = GXt_char7 ;
            new web.concepto_sueldomensual_codigoparam(remoteHandle, context).execute( GXv_char17) ;
            validarconcepto2.this.GXt_char7 = GXv_char17[0] ;
            GXv_char16[0] = GXt_char8 ;
            new web.getparametro(remoteHandle, context).execute( AV16CliCod, GXt_char7, GXv_char16) ;
            validarconcepto2.this.GXt_char8 = GXv_char16[0] ;
            AV109auxConCodigo = GXt_char8 ;
            GXv_decimal10[0] = AV110LiqDCanti ;
            GXv_boolean11[0] = AV52existe ;
            GXv_int19[0] = (byte)(0) ;
            new web.getliqdcantnovedad(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV37LiqNro, AV18LegNumero, AV109auxConCodigo, GXv_decimal10, GXv_boolean11, GXv_int19) ;
            validarconcepto2.this.AV110LiqDCanti = GXv_decimal10[0] ;
            validarconcepto2.this.AV52existe = GXv_boolean11[0] ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, httpContext.getMessage( "existe ", "")+GXutil.trim( GXutil.booltostr( AV52existe))) ;
            if ( AV52existe )
            {
               GXv_int18[0] = AV111diasMes ;
               new web.diasmes(remoteHandle, context).execute( AV16CliCod, AV19LiqPeriodo, GXv_int18) ;
               validarconcepto2.this.AV111diasMes = (byte)((byte)(GXv_int18[0])) ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, httpContext.getMessage( "&liqdcanti ", "")+GXutil.trim( GXutil.str( AV110LiqDCanti, 14, 2))+httpContext.getMessage( " periodo ", "")+GXutil.trim( localUtil.dtoc( AV19LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
               if ( ( AV110LiqDCanti.doubleValue() == 0 ) || ( AV110LiqDCanti.doubleValue() >= AV111diasMes ) )
               {
                  AV8validar = false ;
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, httpContext.getMessage( "no pasa", "")) ;
               }
               else
               {
                  AV112parcialEs = true ;
               }
            }
            new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, httpContext.getMessage( "va ", "")+GXutil.trim( GXutil.booltostr( AV8validar))) ;
            if ( ! AV112parcialEs )
            {
               GXv_char17[0] = AV68MprCod ;
               new web.getlegajomodalidad(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV18LegNumero, GXv_char17) ;
               validarconcepto2.this.AV68MprCod = GXv_char17[0] ;
               GXt_boolean20 = AV8validar ;
               GXv_boolean11[0] = GXt_boolean20 ;
               new web.getmodalidadparcial(remoteHandle, context).execute( AV68MprCod, GXv_boolean11) ;
               validarconcepto2.this.GXt_boolean20 = GXv_boolean11[0] ;
               AV8validar = GXt_boolean20 ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, httpContext.getMessage( "parci ", "")+GXutil.trim( GXutil.booltostr( AV8validar))) ;
            }
         }
         else if ( GXutil.strcmp(AV46ConCondicion, "A3") == 0 )
         {
            GXv_char17[0] = AV120LegModTra ;
            new web.getlegajomodtra(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV18LegNumero, GXv_char17) ;
            validarconcepto2.this.AV120LegModTra = GXv_char17[0] ;
            if ( GXutil.strcmp(AV120LegModTra, "E") != 0 )
            {
               AV8validar = false ;
               AV102LiqDLog = httpContext.getMessage( "Trabajador no es empleado en relación de dependencia", "") ;
            }
            else
            {
               GXv_boolean11[0] = AV118LegLiqApo ;
               new web.getlegliqapo(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV18LegNumero, GXv_boolean11) ;
               validarconcepto2.this.AV118LegLiqApo = GXv_boolean11[0] ;
               if ( ! AV118LegLiqApo )
               {
                  AV8validar = false ;
                  AV102LiqDLog = httpContext.getMessage( "Trabajador no aplica a liquidación de aportes", "") ;
               }
               else
               {
                  GXv_boolean11[0] = AV53LegJubilado ;
                  new web.getlegjubilado(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV18LegNumero, GXv_boolean11) ;
                  validarconcepto2.this.AV53LegJubilado = GXv_boolean11[0] ;
                  if ( AV53LegJubilado )
                  {
                     AV102LiqDLog = httpContext.getMessage( "Trabajador es jubilado", "") ;
                     AV8validar = false ;
                  }
                  else
                  {
                     AV102LiqDLog = httpContext.getMessage( "Trabajador no es jubiliado y aplica a liquidación de aportes", "") ;
                  }
               }
            }
         }
         else if ( GXutil.strcmp(AV46ConCondicion, "LA") == 0 )
         {
            GXv_char17[0] = AV120LegModTra ;
            new web.getlegajomodtra(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV18LegNumero, GXv_char17) ;
            validarconcepto2.this.AV120LegModTra = GXv_char17[0] ;
            if ( GXutil.strcmp(AV120LegModTra, "E") != 0 )
            {
               AV8validar = false ;
               AV102LiqDLog = httpContext.getMessage( "Trabajador no es empleado en relación de dependencia", "") ;
            }
            else
            {
               GXv_boolean11[0] = AV118LegLiqApo ;
               new web.getlegliqapo(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV18LegNumero, GXv_boolean11) ;
               validarconcepto2.this.AV118LegLiqApo = GXv_boolean11[0] ;
               if ( ! AV118LegLiqApo )
               {
                  AV8validar = false ;
                  AV102LiqDLog = httpContext.getMessage( "Trabajador no aplica a liquidación de aportes", "") ;
               }
            }
         }
         else if ( GXutil.strcmp(AV46ConCondicion, "A5") == 0 )
         {
            GXt_char8 = AV48valorParametro ;
            GXt_char7 = AV48valorParametro ;
            GXv_char17[0] = GXt_char7 ;
            new web.adelantoretencionganancias_codigoparam(remoteHandle, context).execute( GXv_char17) ;
            validarconcepto2.this.GXt_char7 = GXv_char17[0] ;
            GXv_char16[0] = GXt_char8 ;
            new web.getparametro(remoteHandle, context).execute( AV16CliCod, GXt_char7, GXv_char16) ;
            validarconcepto2.this.GXt_char8 = GXv_char16[0] ;
            AV48valorParametro = GXt_char8 ;
            if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV48valorParametro)), httpContext.getMessage( "TRUE", "")) != 0 )
            {
               new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, httpContext.getMessage( "1 &ConCondCodigo ", "")+GXutil.trim( AV47ConCondCodigo)+httpContext.getMessage( " &CliCod ", "")+GXutil.trim( GXutil.str( AV16CliCod, 6, 0))+httpContext.getMessage( " &valorParametro ", "")+GXutil.upper( GXutil.trim( AV48valorParametro))) ;
               AV8validar = false ;
            }
         }
         else if ( GXutil.strcmp(AV46ConCondicion, "A4") == 0 )
         {
            GXv_int9[0] = AV55antLiqNro ;
            new web.getliquidacionanteriornosac(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV18LegNumero, AV37LiqNro, false, AV19LiqPeriodo, GXv_int9) ;
            validarconcepto2.this.AV55antLiqNro = GXv_int9[0] ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, httpContext.getMessage( "prinanterior &antLiqNro ", "")+GXutil.trim( GXutil.str( AV55antLiqNro, 8, 0))) ;
            if ( ! (0==AV55antLiqNro) )
            {
               AV64soloNovedades = false ;
               GXv_decimal10[0] = AV54Importes ;
               GXv_decimal3[0] = DecimalUtil.doubleToDec(0) ;
               GXv_boolean11[0] = false ;
               GXv_int18[0] = (short)(0) ;
               GXv_int19[0] = (byte)(0) ;
               new web.getimporteporclassubclasytipoliq(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV18LegNumero, AV55antLiqNro, AV9SubTipoConCod1, "", AV47ConCondCodigo, AV19LiqPeriodo, "Calculo", AV64soloNovedades, GXv_decimal10, GXv_decimal3, GXv_boolean11, GXv_int18, GXv_int19) ;
               validarconcepto2.this.AV54Importes = GXv_decimal10[0] ;
            }
            new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, httpContext.getMessage( "prinanterior &antLiqNro ", "")+GXutil.trim( GXutil.str( AV55antLiqNro, 8, 0))+httpContext.getMessage( " &Importes ", "")+GXutil.trim( GXutil.str( AV54Importes, 14, 2))) ;
            if ( AV54Importes.doubleValue() == 0 )
            {
               AV8validar = false ;
            }
         }
         else if ( GXutil.strcmp(AV46ConCondicion, "B10") == 0 )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, httpContext.getMessage( "&calcularSAC ", "")+GXutil.trim( GXutil.booltostr( AV11calcularSAC))) ;
            if ( ! AV11calcularSAC )
            {
               AV8validar = false ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, httpContext.getMessage( "&validar = false", "")) ;
            }
         }
         else if ( GXutil.strcmp(AV46ConCondicion, "A1") == 0 )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, httpContext.getMessage( "CondicionLiquidacion.ConceptoPrincipal \"", "")+AV47ConCondCodigo+"\"") ;
            if ( GXutil.strcmp(AV47ConCondCodigo, new web.getparametro(remoteHandle, context).executeUdp( AV16CliCod, new web.concepto_liquidasac_codigoparam(remoteHandle, context).executeUdp( ))) == 0 )
            {
               Cond_result = true ;
            }
            else
            {
               Cond_result = false ;
            }
            if ( Cond_result )
            {
               new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, httpContext.getMessage( "&calcularSAC ", "")+GXutil.trim( GXutil.booltostr( AV11calcularSAC))) ;
               if ( ! AV11calcularSAC )
               {
                  Cond_result = true ;
               }
               else
               {
                  Cond_result = false ;
               }
               if ( Cond_result )
               {
                  AV8validar = false ;
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, httpContext.getMessage( "&validar = false", "")) ;
               }
            }
            else
            {
               if ( GXutil.strcmp(AV47ConCondCodigo, new web.getparametro(remoteHandle, context).executeUdp( AV16CliCod, new web.concepto_alcanzaganancias_codigoparam(remoteHandle, context).executeUdp( ))) == 0 )
               {
                  Cond_result = true ;
               }
               else
               {
                  Cond_result = false ;
               }
               if ( Cond_result )
               {
                  if ( ! AV28alcanzaGanancias )
                  {
                     Cond_result = true ;
                  }
                  else
                  {
                     Cond_result = false ;
                  }
                  if ( Cond_result )
                  {
                     AV8validar = false ;
                  }
               }
               else
               {
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, httpContext.getMessage( "!!!! concodigo ", "")+GXutil.trim( AV47ConCondCodigo)) ;
                  GXv_decimal10[0] = AV50LiqDImpCalcu ;
                  GXv_boolean11[0] = false ;
                  GXv_int19[0] = (byte)(0) ;
                  new web.getliqdimpcalcu(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV37LiqNro, AV18LegNumero, AV47ConCondCodigo, AV65ProcesoLiquidacion, AV66insertandoConceptos, GXv_decimal10, GXv_boolean11, GXv_int19) ;
                  validarconcepto2.this.AV50LiqDImpCalcu = GXv_decimal10[0] ;
                  if ( AV50LiqDImpCalcu.doubleValue() == 0 )
                  {
                     Cond_result = true ;
                  }
                  else
                  {
                     Cond_result = false ;
                  }
                  if ( Cond_result )
                  {
                     AV8validar = false ;
                  }
               }
            }
            new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, "2") ;
         }
         else if ( GXutil.strcmp(AV46ConCondicion, "B2") == 0 )
         {
            AV38LegDedConCodigo = AV47ConCondCodigo ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, httpContext.getMessage( "es deduccion &LegDedConCodigo ", "")+GXutil.trim( AV38LegDedConCodigo)) ;
            if ( ! (GXutil.strcmp("", AV38LegDedConCodigo)==0) )
            {
               Cond_result = true ;
            }
            else
            {
               Cond_result = false ;
            }
            if ( Cond_result )
            {
               GXv_decimal10[0] = DecimalUtil.doubleToDec(0) ;
               GXv_boolean11[0] = AV52existe ;
               GXv_int19[0] = (byte)(0) ;
               new web.getliqdimpcalcu(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV37LiqNro, AV18LegNumero, AV38LegDedConCodigo, AV65ProcesoLiquidacion, AV66insertandoConceptos, GXv_decimal10, GXv_boolean11, GXv_int19) ;
               validarconcepto2.this.AV52existe = GXv_boolean11[0] ;
               if ( ! AV52existe )
               {
                  GXv_boolean11[0] = AV94dedExiste ;
                  GXv_decimal10[0] = AV36LegDedImporte ;
                  new web.obtenerimportededuccion(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV37LiqNro, AV18LegNumero, "[monto_siradig]", AV19LiqPeriodo, AV38LegDedConCodigo, false, (byte)(0), "", true, GXv_boolean11, GXv_decimal10) ;
                  validarconcepto2.this.AV94dedExiste = GXv_boolean11[0] ;
                  validarconcepto2.this.AV36LegDedImporte = GXv_decimal10[0] ;
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, httpContext.getMessage( "&LegDedImporte ", "")+GXutil.trim( GXutil.str( AV36LegDedImporte, 14, 2))+httpContext.getMessage( " dedexiste ", "")+GXutil.trim( GXutil.booltostr( AV94dedExiste))) ;
                  if ( ! AV94dedExiste )
                  {
                     AV8validar = false ;
                  }
               }
            }
            new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, httpContext.getMessage( "3 &validar ", "")+GXutil.trim( GXutil.booltostr( AV8validar))+httpContext.getMessage( " &alcanzaGanancias ", "")+GXutil.trim( GXutil.booltostr( AV28alcanzaGanancias))) ;
         }
         else if ( GXutil.strcmp(GXutil.trim( AV14ConFormula), "0") == 0 )
         {
            AV8validar = false ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, "4") ;
         }
         else if ( ( GXutil.strcmp(AV46ConCondicion, "B1") == 0 ) || ( GXutil.strcmp(AV46ConCondicion, "B20") == 0 ) || ( GXutil.strcmp(AV46ConCondicion, "B19") == 0 ) )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, httpContext.getMessage( "1 &LiqPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV19LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &ConCondCodigo ", "")+AV47ConCondCodigo+httpContext.getMessage( " concodigo ", "")+GXutil.trim( AV12ConCodigo)) ;
            AV98buscaConPlus = false ;
            GXv_int19[0] = AV56LegClase ;
            GXv_char17[0] = AV120LegModTra ;
            new web.getlegajoclaseymodtra(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV18LegNumero, GXv_int19, GXv_char17) ;
            validarconcepto2.this.AV56LegClase = GXv_int19[0] ;
            validarconcepto2.this.AV120LegModTra = GXv_char17[0] ;
            if ( ( GXutil.strcmp(AV46ConCondicion, "B20") == 0 ) || ( GXutil.strcmp(AV46ConCondicion, "B19") == 0 ) )
            {
               GXv_int19[0] = AV97EmpTipoExp ;
               new web.getemptipoexp(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, GXv_int19) ;
               validarconcepto2.this.AV97EmpTipoExp = GXv_int19[0] ;
               if ( ( AV97EmpTipoExp == 1 ) || ( AV56LegClase != 1 ) || ( GXutil.strcmp(AV120LegModTra, "E") != 0 ) )
               {
                  AV8validar = false ;
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               GXv_char17[0] = AV121tipo_tarifa ;
               new web.gettipodetarifa(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV37LiqNro, AV18LegNumero, (short)(0), "", "", GXv_char17) ;
               validarconcepto2.this.AV121tipo_tarifa = GXv_char17[0] ;
               if ( GXutil.strcmp(AV121tipo_tarifa, "P") != 0 )
               {
                  AV8validar = false ;
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               GXt_char8 = AV47ConCondCodigo ;
               GXv_char17[0] = GXt_char8 ;
               new web.codigodesituacionvacaciones(remoteHandle, context).execute( AV16CliCod, GXv_char17) ;
               validarconcepto2.this.GXt_char8 = GXv_char17[0] ;
               AV47ConCondCodigo = GXt_char8 ;
               if ( GXutil.strcmp(AV46ConCondicion, "B20") == 0 )
               {
                  AV101distinto = (short)((byte)((true)?1:0)) ;
               }
               else
               {
                  AV101distinto = (short)((byte)((false)?1:0)) ;
               }
            }
            else
            {
               AV101distinto = (short)((byte)((false)?1:0)) ;
            }
            if ( AV8validar )
            {
               GXv_char17[0] = AV61TLiqCod ;
               new web.gettipoliq(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV37LiqNro, GXv_char17) ;
               validarconcepto2.this.AV61TLiqCod = GXv_char17[0] ;
               GXv_date14[0] = AV77iniPeriodo ;
               GXv_date13[0] = AV78finPeriodo ;
               new web.getrangoperiodos(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV37LiqNro, AV18LegNumero, AV61TLiqCod, AV56LegClase, AV19LiqPeriodo, false, GXv_date14, GXv_date13) ;
               validarconcepto2.this.AV77iniPeriodo = GXv_date14[0] ;
               validarconcepto2.this.AV78finPeriodo = GXv_date13[0] ;
               GXv_char17[0] = "" ;
               GXv_int18[0] = AV20LegLicCntDias ;
               GXv_date14[0] = AV21date ;
               GXv_date13[0] = AV21date ;
               GXv_date12[0] = AV21date ;
               GXv_decimal10[0] = DecimalUtil.doubleToDec(0) ;
               GXv_boolean11[0] = false ;
               GXv_char16[0] = AV80auxLiqDLog ;
               new web.legajodevuelvelicencia2(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV18LegNumero, AV37LiqNro, true, AV77iniPeriodo, true, AV78finPeriodo, AV47ConCondCodigo, GXutil.toBoolean( AV101distinto), AV98buscaConPlus, false, GXv_char17, GXv_int18, GXv_date14, GXv_date13, GXv_date12, GXv_decimal10, GXv_boolean11, GXv_char16) ;
               validarconcepto2.this.AV20LegLicCntDias = GXv_int18[0] ;
               validarconcepto2.this.AV21date = GXv_date14[0] ;
               validarconcepto2.this.AV21date = GXv_date13[0] ;
               validarconcepto2.this.AV21date = GXv_date12[0] ;
               validarconcepto2.this.AV80auxLiqDLog = GXv_char16[0] ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, httpContext.getMessage( "auxliqdlog ", "")+AV80auxLiqDLog+httpContext.getMessage( " &EmpTipoExp ", "")+GXutil.trim( GXutil.str( AV97EmpTipoExp, 1, 0))) ;
               if ( AV20LegLicCntDias == 0 )
               {
                  AV8validar = false ;
               }
            }
            new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, "5") ;
            /* Execute user subroutine: 'VALIDAR YA LIQUIDADO' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV46ConCondicion, "A8") == 0 )
         {
            GXv_decimal10[0] = AV24F1357Importes ;
            new web.saldof1357(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV18LegNumero, AV19LiqPeriodo, GXv_decimal10) ;
            validarconcepto2.this.AV24F1357Importes = GXv_decimal10[0] ;
            if ( AV24F1357Importes.doubleValue() == 0 )
            {
               AV8validar = false ;
            }
            new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, "6") ;
         }
         else
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, "8") ;
         }
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV16CliCod, AV128Pgmname, httpContext.getMessage( "concodigo ", "")+GXutil.trim( AV12ConCodigo)+httpContext.getMessage( " &valida ", "")+GXutil.trim( GXutil.booltostr( AV8validar))) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'VALIDAR YA LIQUIDADO' Routine */
      returnInSub = false ;
      if ( AV8validar )
      {
         GXv_boolean11[0] = AV52existe ;
         new web.excluirporyaliquidado(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV37LiqNro, AV18LegNumero, AV19LiqPeriodo, AV65ProcesoLiquidacion, AV46ConCondicion, GXv_boolean11) ;
         validarconcepto2.this.AV52existe = GXv_boolean11[0] ;
         if ( AV52existe )
         {
            AV8validar = false ;
         }
      }
   }

   protected void cleanup( )
   {
      this.aP19[0] = validarconcepto2.this.AV8validar;
      this.aP20[0] = validarconcepto2.this.AV35conceptoObligatorioEs;
      this.aP21[0] = validarconcepto2.this.AV46ConCondicion;
      this.aP22[0] = validarconcepto2.this.AV102LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV46ConCondicion = "" ;
      AV102LiqDLog = "" ;
      AV103noValidoTxt = "" ;
      AV128Pgmname = "" ;
      scmdbuf = "" ;
      P012A2_A26ConCodigo = new String[] {""} ;
      P012A2_A3CliCod = new int[1] ;
      P012A2_A953ConCondicion = new String[] {""} ;
      P012A2_n953ConCondicion = new boolean[] {false} ;
      P012A2_A954ConCondCodigo = new String[] {""} ;
      A26ConCodigo = "" ;
      A953ConCondicion = "" ;
      A954ConCondCodigo = "" ;
      AV47ConCondCodigo = "" ;
      AV121tipo_tarifa = "" ;
      AV89ConveCodigo = "" ;
      AV119tipo_sueldo = "" ;
      AV107LegCatCodigo = "" ;
      AV104parmValue = "" ;
      AV108CatValorHora = DecimalUtil.ZERO ;
      P012A3_A1547GuarCod = new short[1] ;
      P012A3_n1547GuarCod = new boolean[] {false} ;
      P012A3_A6LegNumero = new int[1] ;
      P012A3_A1EmpCod = new short[1] ;
      P012A3_A3CliCod = new int[1] ;
      P012A3_A29LegOrden = new short[1] ;
      AV38LegDedConCodigo = "" ;
      AV91operandos = "" ;
      AV36LegDedImporte = DecimalUtil.ZERO ;
      AV85EmpAntiguedad = DecimalUtil.ZERO ;
      AV92palabra = "" ;
      AV87Importe = DecimalUtil.ZERO ;
      AV88EmpPresentismo = DecimalUtil.ZERO ;
      AV50LiqDImpCalcu = DecimalUtil.ZERO ;
      AV120LegModTra = "" ;
      AV61TLiqCod = "" ;
      AV77iniPeriodo = GXutil.nullDate() ;
      AV78finPeriodo = GXutil.nullDate() ;
      AV21date = GXutil.nullDate() ;
      AV80auxLiqDLog = "" ;
      AV84tipo_feriado = "" ;
      AV99codigo1Palabra = "" ;
      AV116LegFecIngreso = GXutil.nullDate() ;
      AV117LegFecEgreso = GXutil.nullDate() ;
      AV96ferTrabConCodigo = "" ;
      GXv_boolean5 = new boolean[1] ;
      AV73busca2Palabra = "" ;
      GXv_char6 = new String[1] ;
      GXv_char2 = new String[1] ;
      GXv_int4 = new short[1] ;
      GXv_int1 = new byte[1] ;
      AV69OsoAporteAdic = DecimalUtil.ZERO ;
      AV67SinCod = "" ;
      AV109auxConCodigo = "" ;
      AV110LiqDCanti = DecimalUtil.ZERO ;
      AV68MprCod = "" ;
      AV48valorParametro = "" ;
      GXt_char7 = "" ;
      GXv_int9 = new int[1] ;
      AV54Importes = DecimalUtil.ZERO ;
      GXv_decimal3 = new java.math.BigDecimal[1] ;
      GXv_int19 = new byte[1] ;
      GXt_char8 = "" ;
      GXv_char17 = new String[1] ;
      GXv_int18 = new short[1] ;
      GXv_date14 = new java.util.Date[1] ;
      GXv_date13 = new java.util.Date[1] ;
      GXv_date12 = new java.util.Date[1] ;
      GXv_char16 = new String[1] ;
      AV24F1357Importes = DecimalUtil.ZERO ;
      GXv_decimal10 = new java.math.BigDecimal[1] ;
      GXv_boolean11 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.validarconcepto2__default(),
         new Object[] {
             new Object[] {
            P012A2_A26ConCodigo, P012A2_A3CliCod, P012A2_A953ConCondicion, P012A2_n953ConCondicion, P012A2_A954ConCondCodigo
            }
            , new Object[] {
            P012A3_A1547GuarCod, P012A3_n1547GuarCod, P012A3_A6LegNumero, P012A3_A1EmpCod, P012A3_A3CliCod, P012A3_A29LegOrden
            }
         }
      );
      AV128Pgmname = "validarConcepto2" ;
      /* GeneXus formulas. */
      AV128Pgmname = "validarConcepto2" ;
      Gx_err = (short)(0) ;
   }

   private byte AV56LegClase ;
   private byte AV114LegFormaPago ;
   private byte AV130GXLvl113 ;
   private byte AV93LiqDCalculado ;
   private byte AV113auxLiqDCalculado ;
   private byte AV97EmpTipoExp ;
   private byte AV74tipo_total_embargo ;
   private byte GXv_int1[] ;
   private byte AV111diasMes ;
   private byte GXv_int19[] ;
   private short AV17EmpCod ;
   private short AV71PaiCod ;
   private short AV125CliPaiConve ;
   private short A1547GuarCod ;
   private short A1EmpCod ;
   private short A29LegOrden ;
   private short AV20LegLicCntDias ;
   private short GXt_int15 ;
   private short AV70TipoOblSec ;
   private short GXv_int4[] ;
   private short AV101distinto ;
   private short GXv_int18[] ;
   private short Gx_err ;
   private int AV16CliCod ;
   private int AV37LiqNro ;
   private int AV18LegNumero ;
   private int A3CliCod ;
   private int AV106CliConveVer ;
   private int A6LegNumero ;
   private int AV55antLiqNro ;
   private int GXv_int9[] ;
   private java.math.BigDecimal AV108CatValorHora ;
   private java.math.BigDecimal AV36LegDedImporte ;
   private java.math.BigDecimal AV85EmpAntiguedad ;
   private java.math.BigDecimal AV87Importe ;
   private java.math.BigDecimal AV88EmpPresentismo ;
   private java.math.BigDecimal AV50LiqDImpCalcu ;
   private java.math.BigDecimal AV69OsoAporteAdic ;
   private java.math.BigDecimal AV110LiqDCanti ;
   private java.math.BigDecimal AV54Importes ;
   private java.math.BigDecimal GXv_decimal3[] ;
   private java.math.BigDecimal AV24F1357Importes ;
   private java.math.BigDecimal GXv_decimal10[] ;
   private String AV9SubTipoConCod1 ;
   private String AV25SubTipoConCod2 ;
   private String AV12ConCodigo ;
   private String AV22devoGananciasAnioAnteriorConCodigo ;
   private String AV29liquidaSACConCodigo ;
   private String AV30alcanzaGananciasConCodigo ;
   private String AV65ProcesoLiquidacion ;
   private String AV46ConCondicion ;
   private String AV128Pgmname ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String A953ConCondicion ;
   private String A954ConCondCodigo ;
   private String AV47ConCondCodigo ;
   private String AV121tipo_tarifa ;
   private String AV89ConveCodigo ;
   private String AV119tipo_sueldo ;
   private String AV107LegCatCodigo ;
   private String AV38LegDedConCodigo ;
   private String AV91operandos ;
   private String AV92palabra ;
   private String AV120LegModTra ;
   private String AV61TLiqCod ;
   private String AV84tipo_feriado ;
   private String AV99codigo1Palabra ;
   private String AV96ferTrabConCodigo ;
   private String AV73busca2Palabra ;
   private String GXv_char6[] ;
   private String GXv_char2[] ;
   private String AV67SinCod ;
   private String AV109auxConCodigo ;
   private String AV68MprCod ;
   private String AV48valorParametro ;
   private String GXt_char7 ;
   private String GXt_char8 ;
   private String GXv_char17[] ;
   private String GXv_char16[] ;
   private java.util.Date AV19LiqPeriodo ;
   private java.util.Date AV77iniPeriodo ;
   private java.util.Date AV78finPeriodo ;
   private java.util.Date AV21date ;
   private java.util.Date AV116LegFecIngreso ;
   private java.util.Date AV117LegFecEgreso ;
   private java.util.Date GXv_date14[] ;
   private java.util.Date GXv_date13[] ;
   private java.util.Date GXv_date12[] ;
   private boolean AV10calcularContribuciones ;
   private boolean AV11calcularSAC ;
   private boolean AV28alcanzaGanancias ;
   private boolean AV26cargoSiradig ;
   private boolean AV66insertandoConceptos ;
   private boolean AV8validar ;
   private boolean AV35conceptoObligatorioEs ;
   private boolean n953ConCondicion ;
   private boolean AV105desglozar ;
   private boolean AV52existe ;
   private boolean n1547GuarCod ;
   private boolean AV94dedExiste ;
   private boolean AV83manejaFondoCese ;
   private boolean AV13LegAgenReten ;
   private boolean returnInSub ;
   private boolean AV90EmpLiqFer ;
   private boolean AV75hay ;
   private boolean GXv_boolean5[] ;
   private boolean AV112parcialEs ;
   private boolean GXt_boolean20 ;
   private boolean AV118LegLiqApo ;
   private boolean AV53LegJubilado ;
   private boolean AV64soloNovedades ;
   private boolean Cond_result ;
   private boolean AV98buscaConPlus ;
   private boolean GXv_boolean11[] ;
   private String AV14ConFormula ;
   private String AV102LiqDLog ;
   private String AV104parmValue ;
   private String AV80auxLiqDLog ;
   private String AV15ConDescrip ;
   private String AV103noValidoTxt ;
   private String[] aP22 ;
   private boolean[] aP19 ;
   private boolean[] aP20 ;
   private String[] aP21 ;
   private IDataStoreProvider pr_default ;
   private String[] P012A2_A26ConCodigo ;
   private int[] P012A2_A3CliCod ;
   private String[] P012A2_A953ConCondicion ;
   private boolean[] P012A2_n953ConCondicion ;
   private String[] P012A2_A954ConCondCodigo ;
   private short[] P012A3_A1547GuarCod ;
   private boolean[] P012A3_n1547GuarCod ;
   private int[] P012A3_A6LegNumero ;
   private short[] P012A3_A1EmpCod ;
   private int[] P012A3_A3CliCod ;
   private short[] P012A3_A29LegOrden ;
}

final  class validarconcepto2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P012A2", "SELECT ConCodigo, CliCod, ConCondicion, ConCondCodigo FROM Concepto WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P012A3", "SELECT GuarCod, LegNumero, EmpCod, CliCod, LegOrden FROM LegajoFamilia WHERE (CliCod = ? and EmpCod = ? and LegNumero = ?) AND (Not (GuarCod = 0) and Not GuarCod IS NULL) ORDER BY CliCod, EmpCod, LegNumero  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(4, 20);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((int[]) buf[2])[0] = rslt.getInt(2);
               ((short[]) buf[3])[0] = rslt.getShort(3);
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((short[]) buf[5])[0] = rslt.getShort(5);
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

