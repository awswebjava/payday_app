package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class base_calculo_os_diferencial extends GXProcedure
{
   public base_calculo_os_diferencial( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( base_calculo_os_diferencial.class ), "" );
   }

   public base_calculo_os_diferencial( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             java.util.Date aP5 ,
                             String aP6 ,
                             String aP7 ,
                             java.math.BigDecimal[] aP8 ,
                             byte[] aP9 ,
                             String[] aP10 )
   {
      base_calculo_os_diferencial.this.aP11 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
      return aP11[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        int aP4 ,
                        java.util.Date aP5 ,
                        String aP6 ,
                        String aP7 ,
                        java.math.BigDecimal[] aP8 ,
                        byte[] aP9 ,
                        String[] aP10 ,
                        String[] aP11 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             java.util.Date aP5 ,
                             String aP6 ,
                             String aP7 ,
                             java.math.BigDecimal[] aP8 ,
                             byte[] aP9 ,
                             String[] aP10 ,
                             String[] aP11 )
   {
      base_calculo_os_diferencial.this.AV11CliCod = aP0;
      base_calculo_os_diferencial.this.AV12EmpCod = aP1;
      base_calculo_os_diferencial.this.AV13LiqNro = aP2;
      base_calculo_os_diferencial.this.AV71LiqRelNro = aP3;
      base_calculo_os_diferencial.this.AV14LegNumero = aP4;
      base_calculo_os_diferencial.this.AV23LiqPeriodo = aP5;
      base_calculo_os_diferencial.this.AV61baseImpConCodigo = aP6;
      base_calculo_os_diferencial.this.AV27ProcesoLiquidacion = aP7;
      base_calculo_os_diferencial.this.aP8 = aP8;
      base_calculo_os_diferencial.this.aP9 = aP9;
      base_calculo_os_diferencial.this.aP10 = aP10;
      base_calculo_os_diferencial.this.aP11 = aP11;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV33LiqDCalculado = (byte)(1) ;
      AV8desdeTipoConCod = "NRE_ARG" ;
      AV9hastaTipoConCod = "REM_ARG" ;
      GXv_char1[0] = AV10sueldoMensualConCodigo ;
      new web.getparametro(remoteHandle, context).execute( AV11CliCod, new web.concepto_sueldomensual_codigoparam(remoteHandle, context).executeUdp( ), GXv_char1) ;
      base_calculo_os_diferencial.this.AV10sueldoMensualConCodigo = GXv_char1[0] ;
      GXt_char2 = AV55subtipoSAC ;
      GXv_char1[0] = GXt_char2 ;
      new web.subtiposac(remoteHandle, context).execute( GXv_char1) ;
      base_calculo_os_diferencial.this.GXt_char2 = GXv_char1[0] ;
      AV55subtipoSAC = GXt_char2 ;
      GXt_char2 = AV58subtipoVacaciones ;
      GXv_char1[0] = GXt_char2 ;
      new web.subtipovacaciones(remoteHandle, context).execute( GXv_char1) ;
      base_calculo_os_diferencial.this.GXt_char2 = GXv_char1[0] ;
      AV58subtipoVacaciones = GXt_char2 ;
      GXt_char2 = AV56subtipo2AdelantoVacaciones ;
      GXv_char1[0] = GXt_char2 ;
      new web.conceptoafipadelantovacaciones(remoteHandle, context).execute( GXv_char1) ;
      base_calculo_os_diferencial.this.GXt_char2 = GXv_char1[0] ;
      AV56subtipo2AdelantoVacaciones = GXt_char2 ;
      GXt_char2 = AV65subtipo2SACPropor ;
      GXv_char1[0] = GXt_char2 ;
      new web.subtipo2sacpropor(remoteHandle, context).execute( GXv_char1) ;
      base_calculo_os_diferencial.this.GXt_char2 = GXv_char1[0] ;
      AV65subtipo2SACPropor = GXt_char2 ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV81Pgmname, httpContext.getMessage( "&QUE ", "")+GXutil.trim( AV20que)) ;
      AV82GXLvl21 = (byte)(0) ;
      /* Using cursor P01PN2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV14LegNumero), Integer.valueOf(AV13LiqNro), AV8desdeTipoConCod, AV9hastaTipoConCod, Integer.valueOf(AV71LiqRelNro), AV23LiqPeriodo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2112LiqRelNro = P01PN2_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P01PN2_n2112LiqRelNro[0] ;
         A1058LiqDFonSolRedCont = P01PN2_A1058LiqDFonSolRedCont[0] ;
         A1056LiqDObraSocCont = P01PN2_A1056LiqDObraSocCont[0] ;
         A1057LiqDFonSolRedApo = P01PN2_A1057LiqDFonSolRedApo[0] ;
         A1055LiqDObraSocApo = P01PN2_A1055LiqDObraSocApo[0] ;
         A464DTipoConCod = P01PN2_A464DTipoConCod[0] ;
         A6LegNumero = P01PN2_A6LegNumero[0] ;
         A397DLiqPeriodo = P01PN2_A397DLiqPeriodo[0] ;
         A31LiqNro = P01PN2_A31LiqNro[0] ;
         A1EmpCod = P01PN2_A1EmpCod[0] ;
         A3CliCod = P01PN2_A3CliCod[0] ;
         A394DConCodigo = P01PN2_A394DConCodigo[0] ;
         A504LiqDForOrig = P01PN2_A504LiqDForOrig[0] ;
         A507LiqDCalculado = P01PN2_A507LiqDCalculado[0] ;
         A393DConDescrip = P01PN2_A393DConDescrip[0] ;
         A764LiqDImpReCalcu = P01PN2_A764LiqDImpReCalcu[0] ;
         A732DSubTipoConCod2 = P01PN2_A732DSubTipoConCod2[0] ;
         n732DSubTipoConCod2 = P01PN2_n732DSubTipoConCod2[0] ;
         A468DSubTipoConCod1 = P01PN2_A468DSubTipoConCod1[0] ;
         n468DSubTipoConCod1 = P01PN2_n468DSubTipoConCod1[0] ;
         A269LiqDCanti = P01PN2_A269LiqDCanti[0] ;
         n269LiqDCanti = P01PN2_n269LiqDCanti[0] ;
         A81LiqDSecuencial = P01PN2_A81LiqDSecuencial[0] ;
         A2112LiqRelNro = P01PN2_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P01PN2_n2112LiqRelNro[0] ;
         AV82GXLvl21 = (byte)(1) ;
         AV15resolver = false ;
         AV16agregar = false ;
         AV54propAComp = false ;
         GXv_int3[0] = AV48ConBaseOSDif ;
         new web.getconceptobaseosdif(remoteHandle, context).execute( AV11CliCod, A394DConCodigo, GXv_int3) ;
         base_calculo_os_diferencial.this.AV48ConBaseOSDif = GXv_int3[0] ;
         if ( AV48ConBaseOSDif != 0 )
         {
            AV16agregar = true ;
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV81Pgmname, httpContext.getMessage( "agregar ", "")+GXutil.trim( GXutil.booltostr( AV16agregar))+httpContext.getMessage( " es_base ", "")+GXutil.trim( GXutil.str( AV21es_base_OSDif, 1, 0))+httpContext.getMessage( " dconcodigo ", "")+A394DConCodigo) ;
         if ( AV16agregar )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV81Pgmname, httpContext.getMessage( "agrega1", "")) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV81Pgmname, httpContext.getMessage( "agrega2", "")) ;
            if ( AV48ConBaseOSDif == 1 )
            {
               if ( GXutil.strcmp(A394DConCodigo, AV10sueldoMensualConCodigo) == 0 )
               {
                  GXv_int4[0] = (short)(DecimalUtil.decToDouble(AV52LiqDCanti)) ;
                  new web.diasmes(remoteHandle, context).execute( AV11CliCod, A397DLiqPeriodo, GXv_int4) ;
                  base_calculo_os_diferencial.this.AV52LiqDCanti = DecimalUtil.doubleToDec(GXv_int4[0]) ;
                  GXv_boolean5[0] = AV49MprEsParcial ;
                  GXv_decimal6[0] = AV50horasSemanaNormal ;
                  GXv_decimal7[0] = AV51LegHorasSem ;
                  new web.reduceporparcialdeterminado(remoteHandle, context).execute( AV11CliCod, AV12EmpCod, AV14LegNumero, GXv_boolean5, GXv_decimal6, GXv_decimal7) ;
                  base_calculo_os_diferencial.this.AV49MprEsParcial = GXv_boolean5[0] ;
                  base_calculo_os_diferencial.this.AV50horasSemanaNormal = GXv_decimal6[0] ;
                  base_calculo_os_diferencial.this.AV51LegHorasSem = GXv_decimal7[0] ;
                  if ( ! AV49MprEsParcial )
                  {
                     AV15resolver = true ;
                  }
               }
               else
               {
                  AV15resolver = true ;
                  AV52LiqDCanti = DecimalUtil.doubleToDec(0) ;
               }
               AV54propAComp = true ;
            }
            if ( AV15resolver )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV81Pgmname, httpContext.getMessage( "agrega3", "")) ;
               GXv_boolean5[0] = false ;
               GXv_char1[0] = AV29auxError ;
               GXv_char8[0] = "" ;
               GXv_char9[0] = "" ;
               GXv_char10[0] = "" ;
               GXv_decimal7[0] = AV30LiqDImpCalcu ;
               GXv_boolean11[0] = AV31dependenciasResueltas ;
               GXv_decimal6[0] = DecimalUtil.doubleToDec(0) ;
               GXv_boolean12[0] = false ;
               GXv_decimal13[0] = DecimalUtil.doubleToDec(0) ;
               GXv_decimal14[0] = DecimalUtil.doubleToDec(0) ;
               GXv_boolean15[0] = false ;
               GXv_char16[0] = AV32auxLiqDLog ;
               GXv_decimal17[0] = DecimalUtil.doubleToDec(0) ;
               GXv_boolean18[0] = false ;
               new web.resolverformula(remoteHandle, context).execute( AV11CliCod, A394DConCodigo, A504LiqDForOrig, A504LiqDForOrig, AV12EmpCod, AV13LiqNro, AV13LiqNro, AV71LiqRelNro, AV14LegNumero, AV26nadaTLiqCod, AV23LiqPeriodo, AV81Pgmname, AV27ProcesoLiquidacion, true, AV52LiqDCanti, AV28date, DecimalUtil.doubleToDec(0), DecimalUtil.doubleToDec(0), GXv_boolean5, GXv_char1, GXv_char8, GXv_char9, GXv_char10, GXv_decimal7, GXv_boolean11, GXv_decimal6, GXv_boolean12, GXv_decimal13, GXv_decimal14, GXv_boolean15, GXv_char16, GXv_decimal17, GXv_boolean18) ;
               base_calculo_os_diferencial.this.AV29auxError = GXv_char1[0] ;
               base_calculo_os_diferencial.this.AV30LiqDImpCalcu = GXv_decimal7[0] ;
               base_calculo_os_diferencial.this.AV31dependenciasResueltas = GXv_boolean11[0] ;
               base_calculo_os_diferencial.this.AV32auxLiqDLog = GXv_char16[0] ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV81Pgmname, httpContext.getMessage( "DConCodigo ", "")+GXutil.trim( A394DConCodigo)+httpContext.getMessage( " &dependenciasResueltas ", "")+GXutil.trim( GXutil.booltostr( AV31dependenciasResueltas))+httpContext.getMessage( " &liqdimpcalcu ", "")+GXutil.trim( GXutil.str( AV30LiqDImpCalcu, 14, 2))+httpContext.getMessage( " &auxError ", "")+GXutil.trim( AV29auxError)) ;
               if ( ! AV31dependenciasResueltas || ! (GXutil.strcmp("", AV29auxError)==0) )
               {
                  AV33LiqDCalculado = (byte)(0) ;
                  AV34error = AV29auxError ;
                  AV35LiqDLog = AV34error ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV81Pgmname, httpContext.getMessage( "&LiqDLog ", "")+AV35LiqDLog) ;
                  pr_default.close(0);
                  pr_default.close(0);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
            else
            {
               if ( A507LiqDCalculado == 0 )
               {
                  AV33LiqDCalculado = (byte)(0) ;
                  AV34error = httpContext.getMessage( "Falta calcular ", "") + GXutil.trim( A393DConDescrip) ;
                  AV35LiqDLog = AV34error ;
                  pr_default.close(0);
                  pr_default.close(0);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               AV30LiqDImpCalcu = A764LiqDImpReCalcu ;
               AV76parcialLiqDImpCalcu = AV30LiqDImpCalcu ;
               if ( ( GXutil.strcmp(A394DConCodigo, AV10sueldoMensualConCodigo) == 0 ) || ( AV48ConBaseOSDif == 3 ) )
               {
                  if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV51LegHorasSem)==0) )
                  {
                     AV53porUnaje = AV50horasSemanaNormal.divide(AV51LegHorasSem, 18, java.math.RoundingMode.DOWN) ;
                     AV30LiqDImpCalcu = AV30LiqDImpCalcu.multiply(AV53porUnaje) ;
                     AV54propAComp = true ;
                  }
               }
            }
            if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV30LiqDImpCalcu)==0) )
            {
               if ( ( GXutil.strcmp(A468DSubTipoConCod1, AV55subtipoSAC) != 0 ) && ( GXutil.strcmp(A732DSubTipoConCod2, AV56subtipo2AdelantoVacaciones) != 0 ) || P01PN2_n732DSubTipoConCod2[0] )
               {
                  AV57SueldoImportes = AV57SueldoImportes.add(AV30LiqDImpCalcu) ;
                  AV75parcialSueldoImportes = AV75parcialSueldoImportes.add(AV76parcialLiqDImpCalcu) ;
               }
               else
               {
                  if ( ( GXutil.strcmp(A468DSubTipoConCod1, AV58subtipoVacaciones) == 0 ) && ( GXutil.strcmp(A732DSubTipoConCod2, AV56subtipo2AdelantoVacaciones) == 0 ) )
                  {
                     AV59adelantoVacImportes = AV59adelantoVacImportes.add(AV30LiqDImpCalcu) ;
                     AV70dias_vacaciones = (short)(DecimalUtil.decToDouble(DecimalUtil.doubleToDec(AV70dias_vacaciones).add(A269LiqDCanti))) ;
                     AV77parcialVacImportes = AV77parcialVacImportes.add(AV76parcialLiqDImpCalcu) ;
                  }
                  else
                  {
                     if ( GXutil.strcmp(A468DSubTipoConCod1, AV55subtipoSAC) == 0 )
                     {
                        if ( GXutil.strcmp(A732DSubTipoConCod2, AV65subtipo2SACPropor) == 0 )
                        {
                           AV66sacProporcionalImportes = AV66sacProporcionalImportes.add(AV30LiqDImpCalcu) ;
                        }
                        else
                        {
                           AV67sacImportes = AV67sacImportes.add(AV30LiqDImpCalcu) ;
                        }
                        AV78parcialSacImportes = AV78parcialSacImportes.add(AV76parcialLiqDImpCalcu) ;
                     }
                  }
               }
               if ( (GXutil.strcmp("", AV35LiqDLog)==0) )
               {
                  AV35LiqDLog = httpContext.getMessage( "Inicializa con ", "") ;
               }
               else
               {
                  AV35LiqDLog += httpContext.getMessage( ". Agrega ", "") ;
               }
               AV35LiqDLog += GXutil.trim( GXutil.str( AV30LiqDImpCalcu, 14, 2)) + httpContext.getMessage( " de ", "") + GXutil.trim( A393DConDescrip) ;
               if ( AV54propAComp )
               {
                  AV35LiqDLog += httpContext.getMessage( " (proporcionado a jornada completa)", "") ;
               }
            }
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV82GXLvl21 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV81Pgmname, httpContext.getMessage( "none", "")) ;
      }
      GXt_char2 = AV63baseAportesConCodigo ;
      GXt_char19 = AV63baseAportesConCodigo ;
      GXv_char16[0] = GXt_char19 ;
      new web.parametro_concepto_lsd_basedifapoosfsr(remoteHandle, context).execute( GXv_char16) ;
      base_calculo_os_diferencial.this.GXt_char19 = GXv_char16[0] ;
      GXv_char10[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV11CliCod, GXt_char19, GXv_char10) ;
      base_calculo_os_diferencial.this.GXt_char2 = GXv_char10[0] ;
      AV63baseAportesConCodigo = GXt_char2 ;
      if ( GXutil.strcmp(AV61baseImpConCodigo, AV63baseAportesConCodigo) == 0 )
      {
         GXv_int4[0] = AV45diasMes ;
         new web.diasmes(remoteHandle, context).execute( AV11CliCod, AV23LiqPeriodo, GXv_int4) ;
         base_calculo_os_diferencial.this.AV45diasMes = (byte)((byte)(GXv_int4[0])) ;
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV57SueldoImportes)==0) )
         {
            GXv_int3[0] = AV36auxLiqDCalculado ;
            GXv_char16[0] = AV32auxLiqDLog ;
            GXv_char10[0] = AV29auxError ;
            GXv_decimal17[0] = DecimalUtil.doubleToDec(0) ;
            GXv_decimal14[0] = AV60topeSueldosImportes ;
            GXv_int4[0] = (short)(0) ;
            new web.maximo_imponible_sueldo(remoteHandle, context).execute( AV11CliCod, AV12EmpCod, AV13LiqNro, AV14LegNumero, AV23LiqPeriodo, AV45diasMes, AV57SueldoImportes, AV27ProcesoLiquidacion, false, GXv_int3, GXv_char16, GXv_char10, GXv_decimal17, GXv_decimal14, GXv_int4) ;
            base_calculo_os_diferencial.this.AV36auxLiqDCalculado = GXv_int3[0] ;
            base_calculo_os_diferencial.this.AV32auxLiqDLog = GXv_char16[0] ;
            base_calculo_os_diferencial.this.AV29auxError = GXv_char10[0] ;
            base_calculo_os_diferencial.this.AV60topeSueldosImportes = GXv_decimal14[0] ;
            if ( AV36auxLiqDCalculado == 0 )
            {
               AV33LiqDCalculado = (byte)(0) ;
               AV34error = GXutil.trim( AV29auxError) ;
               AV35LiqDLog = GXutil.trim( AV34error) ;
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            else
            {
               if ( DecimalUtil.compareTo(AV57SueldoImportes, AV60topeSueldosImportes) == 0 )
               {
                  AV35LiqDLog += httpContext.getMessage( ". Suma ", "") + GXutil.trim( GXutil.str( AV57SueldoImportes, 14, 2)) + httpContext.getMessage( " de sueldo", "") ;
               }
               else
               {
                  AV35LiqDLog += httpContext.getMessage( ". Suma importe de sueldo topeado ", "") + GXutil.trim( GXutil.str( AV60topeSueldosImportes, 14, 2)) ;
               }
               AV37Importes = AV37Importes.add(AV60topeSueldosImportes) ;
            }
         }
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV59adelantoVacImportes)==0) )
         {
            GXv_char16[0] = AV32auxLiqDLog ;
            GXv_decimal17[0] = DecimalUtil.doubleToDec(0) ;
            GXv_decimal14[0] = AV64topeVacacionesImportes ;
            GXv_int4[0] = (short)(0) ;
            GXv_char10[0] = AV29auxError ;
            new web.maximo_imponible_adelvac(remoteHandle, context).execute( AV11CliCod, AV12EmpCod, AV13LiqNro, AV14LegNumero, AV23LiqPeriodo, AV45diasMes, AV59adelantoVacImportes, AV27ProcesoLiquidacion, AV70dias_vacaciones, GXv_char16, GXv_decimal17, GXv_decimal14, GXv_int4, GXv_char10) ;
            base_calculo_os_diferencial.this.AV32auxLiqDLog = GXv_char16[0] ;
            base_calculo_os_diferencial.this.AV64topeVacacionesImportes = GXv_decimal14[0] ;
            base_calculo_os_diferencial.this.AV29auxError = GXv_char10[0] ;
            if ( ! (GXutil.strcmp("", AV29auxError)==0) )
            {
               AV33LiqDCalculado = (byte)(0) ;
               AV34error = AV29auxError ;
               AV35LiqDLog = AV34error ;
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            if ( DecimalUtil.compareTo(AV59adelantoVacImportes, AV64topeVacacionesImportes) == 0 )
            {
               AV35LiqDLog += httpContext.getMessage( ". Suma ", "") + GXutil.trim( GXutil.str( AV59adelantoVacImportes, 14, 2)) + httpContext.getMessage( " correspondientes a adelanto de vacaciones", "") ;
            }
            else
            {
               AV35LiqDLog += httpContext.getMessage( ". Suma ", "") + GXutil.trim( GXutil.str( AV64topeVacacionesImportes, 14, 2)) + httpContext.getMessage( " correspondientes a adelanto de vacaciones topeado", "") ;
            }
            AV37Importes = AV37Importes.add(AV64topeVacacionesImportes) ;
         }
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV67sacImportes)==0) || ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV66sacProporcionalImportes)==0) )
         {
            GXv_int3[0] = AV36auxLiqDCalculado ;
            GXv_char16[0] = AV32auxLiqDLog ;
            GXv_char10[0] = AV29auxError ;
            GXv_decimal17[0] = DecimalUtil.doubleToDec(0) ;
            GXv_decimal14[0] = AV68topeSACImportes ;
            GXv_int4[0] = (short)(0) ;
            new web.maximo_imponible_sac(remoteHandle, context).execute( AV11CliCod, AV12EmpCod, AV13LiqNro, AV71LiqRelNro, AV14LegNumero, AV23LiqPeriodo, AV45diasMes, AV67sacImportes, AV66sacProporcionalImportes, true, AV27ProcesoLiquidacion, false, GXv_int3, GXv_char16, GXv_char10, GXv_decimal17, GXv_decimal14, GXv_int4) ;
            base_calculo_os_diferencial.this.AV36auxLiqDCalculado = GXv_int3[0] ;
            base_calculo_os_diferencial.this.AV32auxLiqDLog = GXv_char16[0] ;
            base_calculo_os_diferencial.this.AV29auxError = GXv_char10[0] ;
            base_calculo_os_diferencial.this.AV68topeSACImportes = GXv_decimal14[0] ;
            if ( AV36auxLiqDCalculado == 0 )
            {
               AV33LiqDCalculado = (byte)(0) ;
               AV34error = GXutil.trim( AV29auxError) ;
               AV35LiqDLog = GXutil.trim( AV34error) ;
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            else
            {
               if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV67sacImportes)==0) )
               {
                  if ( DecimalUtil.compareTo(AV67sacImportes, AV68topeSACImportes) == 0 )
                  {
                     AV35LiqDLog += httpContext.getMessage( ". Suma ", "") + GXutil.trim( GXutil.str( AV67sacImportes, 14, 2)) + httpContext.getMessage( " correspondiente a SAC", "") ;
                  }
                  else
                  {
                     AV35LiqDLog += httpContext.getMessage( ". Suma ", "") + GXutil.trim( GXutil.str( AV68topeSACImportes, 14, 2)) + httpContext.getMessage( " correspondiente a SAC topeado &sacImportes ", "") + GXutil.trim( GXutil.str( AV67sacImportes, 14, 2)) + httpContext.getMessage( " &topeSACImportes ", "") + GXutil.trim( GXutil.str( AV68topeSACImportes, 14, 2)) ;
                  }
               }
               else
               {
                  if ( DecimalUtil.compareTo(AV66sacProporcionalImportes, AV68topeSACImportes) == 0 )
                  {
                     AV35LiqDLog += httpContext.getMessage( ". Suma ", "") + GXutil.trim( GXutil.str( AV66sacProporcionalImportes, 14, 2)) + httpContext.getMessage( " correspondiente a SAC proporcional ", "") ;
                  }
                  else
                  {
                     AV35LiqDLog += httpContext.getMessage( "Suma ", "") + GXutil.trim( GXutil.str( AV68topeSACImportes, 14, 2)) + httpContext.getMessage( " correspondiente a SAC proporcional topeado", "") ;
                  }
               }
               AV37Importes = AV37Importes.add(AV68topeSACImportes) ;
            }
         }
         AV73auxImportes = AV75parcialSueldoImportes.add(AV77parcialVacImportes).add(AV78parcialSacImportes) ;
         AV74auxTopeImportes = AV68topeSACImportes.add(AV60topeSueldosImportes).add(AV64topeVacacionesImportes) ;
         if ( DecimalUtil.compareTo(AV73auxImportes, (AV74auxTopeImportes)) >= 0 )
         {
            AV35LiqDLog = httpContext.getMessage( "Se asigna valor en cero por ser la remuneración parcial ", "") + GXutil.trim( GXutil.str( AV73auxImportes, 14, 2)) + httpContext.getMessage( " mayor o igual al tope imponible ", "") + GXutil.trim( GXutil.str( AV74auxTopeImportes, 14, 2)) ;
            AV37Importes = DecimalUtil.ZERO ;
         }
      }
      else
      {
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV57SueldoImportes)==0) )
         {
            AV37Importes = AV37Importes.add(AV57SueldoImportes) ;
            AV35LiqDLog += httpContext.getMessage( ". Suma ", "") + GXutil.trim( GXutil.str( AV57SueldoImportes, 14, 2)) ;
         }
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV59adelantoVacImportes)==0) )
         {
            AV37Importes = AV37Importes.add(AV59adelantoVacImportes) ;
            AV35LiqDLog += httpContext.getMessage( ". Suma ", "") + GXutil.trim( GXutil.str( AV59adelantoVacImportes, 14, 2)) + httpContext.getMessage( " correspondiente a adelanto de vacaciones.", "") ;
         }
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV67sacImportes)==0) )
         {
            AV37Importes = AV37Importes.add(AV67sacImportes) ;
            AV35LiqDLog += httpContext.getMessage( ". Suma ", "") + GXutil.trim( GXutil.str( AV67sacImportes, 14, 2)) + httpContext.getMessage( " correspondiente a SAC", "") ;
         }
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV66sacProporcionalImportes)==0) )
         {
            AV37Importes = AV37Importes.add(AV66sacProporcionalImportes) ;
            AV35LiqDLog += httpContext.getMessage( ". Suma ", "") + GXutil.trim( GXutil.str( AV66sacProporcionalImportes, 14, 2)) + httpContext.getMessage( " correspondiente a SAC Proporcional", "") ;
         }
      }
      if ( AV37Importes.doubleValue() > 0 )
      {
         GXv_decimal17[0] = AV62baseImpLiqDImpCalcu ;
         new web.getliqdimpcalcu_periodoliqant(remoteHandle, context).execute( AV11CliCod, AV12EmpCod, AV13LiqNro, AV14LegNumero, AV23LiqPeriodo, AV61baseImpConCodigo, false, GXv_decimal17) ;
         base_calculo_os_diferencial.this.AV62baseImpLiqDImpCalcu = GXv_decimal17[0] ;
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV62baseImpLiqDImpCalcu)==0) )
         {
            AV83Importe = AV83Importe.subtract(AV62baseImpLiqDImpCalcu) ;
            AV35LiqDLog += httpContext.getMessage( ". Se resta ", "") + GXutil.trim( GXutil.str( AV62baseImpLiqDImpCalcu, 14, 2)) + httpContext.getMessage( " correspondientes a liquidaciones anteriores del periodo", "") ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP8[0] = base_calculo_os_diferencial.this.AV37Importes;
      this.aP9[0] = base_calculo_os_diferencial.this.AV33LiqDCalculado;
      this.aP10[0] = base_calculo_os_diferencial.this.AV35LiqDLog;
      this.aP11[0] = base_calculo_os_diferencial.this.AV34error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV37Importes = DecimalUtil.ZERO ;
      AV35LiqDLog = "" ;
      AV34error = "" ;
      AV8desdeTipoConCod = "" ;
      AV9hastaTipoConCod = "" ;
      AV10sueldoMensualConCodigo = "" ;
      AV55subtipoSAC = "" ;
      AV58subtipoVacaciones = "" ;
      AV56subtipo2AdelantoVacaciones = "" ;
      AV65subtipo2SACPropor = "" ;
      AV81Pgmname = "" ;
      AV20que = "" ;
      scmdbuf = "" ;
      P01PN2_A2112LiqRelNro = new int[1] ;
      P01PN2_n2112LiqRelNro = new boolean[] {false} ;
      P01PN2_A1058LiqDFonSolRedCont = new byte[1] ;
      P01PN2_A1056LiqDObraSocCont = new byte[1] ;
      P01PN2_A1057LiqDFonSolRedApo = new byte[1] ;
      P01PN2_A1055LiqDObraSocApo = new byte[1] ;
      P01PN2_A464DTipoConCod = new String[] {""} ;
      P01PN2_A6LegNumero = new int[1] ;
      P01PN2_A397DLiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P01PN2_A31LiqNro = new int[1] ;
      P01PN2_A1EmpCod = new short[1] ;
      P01PN2_A3CliCod = new int[1] ;
      P01PN2_A394DConCodigo = new String[] {""} ;
      P01PN2_A504LiqDForOrig = new String[] {""} ;
      P01PN2_A507LiqDCalculado = new byte[1] ;
      P01PN2_A393DConDescrip = new String[] {""} ;
      P01PN2_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01PN2_A732DSubTipoConCod2 = new String[] {""} ;
      P01PN2_n732DSubTipoConCod2 = new boolean[] {false} ;
      P01PN2_A468DSubTipoConCod1 = new String[] {""} ;
      P01PN2_n468DSubTipoConCod1 = new boolean[] {false} ;
      P01PN2_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01PN2_n269LiqDCanti = new boolean[] {false} ;
      P01PN2_A81LiqDSecuencial = new int[1] ;
      A464DTipoConCod = "" ;
      A397DLiqPeriodo = GXutil.nullDate() ;
      A394DConCodigo = "" ;
      A504LiqDForOrig = "" ;
      A393DConDescrip = "" ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      A732DSubTipoConCod2 = "" ;
      A468DSubTipoConCod1 = "" ;
      A269LiqDCanti = DecimalUtil.ZERO ;
      AV52LiqDCanti = DecimalUtil.ZERO ;
      AV50horasSemanaNormal = DecimalUtil.ZERO ;
      AV51LegHorasSem = DecimalUtil.ZERO ;
      AV26nadaTLiqCod = "" ;
      AV28date = GXutil.nullDate() ;
      GXv_boolean5 = new boolean[1] ;
      AV29auxError = "" ;
      GXv_char1 = new String[1] ;
      GXv_char8 = new String[1] ;
      GXv_char9 = new String[1] ;
      AV30LiqDImpCalcu = DecimalUtil.ZERO ;
      GXv_decimal7 = new java.math.BigDecimal[1] ;
      GXv_boolean11 = new boolean[1] ;
      GXv_decimal6 = new java.math.BigDecimal[1] ;
      GXv_boolean12 = new boolean[1] ;
      GXv_decimal13 = new java.math.BigDecimal[1] ;
      GXv_boolean15 = new boolean[1] ;
      AV32auxLiqDLog = "" ;
      GXv_boolean18 = new boolean[1] ;
      AV76parcialLiqDImpCalcu = DecimalUtil.ZERO ;
      AV53porUnaje = DecimalUtil.ZERO ;
      AV57SueldoImportes = DecimalUtil.ZERO ;
      AV75parcialSueldoImportes = DecimalUtil.ZERO ;
      AV59adelantoVacImportes = DecimalUtil.ZERO ;
      AV77parcialVacImportes = DecimalUtil.ZERO ;
      AV66sacProporcionalImportes = DecimalUtil.ZERO ;
      AV67sacImportes = DecimalUtil.ZERO ;
      AV78parcialSacImportes = DecimalUtil.ZERO ;
      AV63baseAportesConCodigo = "" ;
      GXt_char2 = "" ;
      GXt_char19 = "" ;
      AV60topeSueldosImportes = DecimalUtil.ZERO ;
      AV64topeVacacionesImportes = DecimalUtil.ZERO ;
      GXv_int3 = new byte[1] ;
      GXv_char16 = new String[1] ;
      GXv_char10 = new String[1] ;
      AV68topeSACImportes = DecimalUtil.ZERO ;
      GXv_decimal14 = new java.math.BigDecimal[1] ;
      GXv_int4 = new short[1] ;
      AV73auxImportes = DecimalUtil.ZERO ;
      AV74auxTopeImportes = DecimalUtil.ZERO ;
      AV62baseImpLiqDImpCalcu = DecimalUtil.ZERO ;
      GXv_decimal17 = new java.math.BigDecimal[1] ;
      AV83Importe = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.base_calculo_os_diferencial__default(),
         new Object[] {
             new Object[] {
            P01PN2_A2112LiqRelNro, P01PN2_n2112LiqRelNro, P01PN2_A1058LiqDFonSolRedCont, P01PN2_A1056LiqDObraSocCont, P01PN2_A1057LiqDFonSolRedApo, P01PN2_A1055LiqDObraSocApo, P01PN2_A464DTipoConCod, P01PN2_A6LegNumero, P01PN2_A397DLiqPeriodo, P01PN2_A31LiqNro,
            P01PN2_A1EmpCod, P01PN2_A3CliCod, P01PN2_A394DConCodigo, P01PN2_A504LiqDForOrig, P01PN2_A507LiqDCalculado, P01PN2_A393DConDescrip, P01PN2_A764LiqDImpReCalcu, P01PN2_A732DSubTipoConCod2, P01PN2_n732DSubTipoConCod2, P01PN2_A468DSubTipoConCod1,
            P01PN2_n468DSubTipoConCod1, P01PN2_A269LiqDCanti, P01PN2_n269LiqDCanti, P01PN2_A81LiqDSecuencial
            }
         }
      );
      AV81Pgmname = "base_calculo_os_diferencial" ;
      /* GeneXus formulas. */
      AV81Pgmname = "base_calculo_os_diferencial" ;
      Gx_err = (short)(0) ;
   }

   private byte AV33LiqDCalculado ;
   private byte AV82GXLvl21 ;
   private byte A1058LiqDFonSolRedCont ;
   private byte A1056LiqDObraSocCont ;
   private byte A1057LiqDFonSolRedApo ;
   private byte A1055LiqDObraSocApo ;
   private byte A507LiqDCalculado ;
   private byte AV48ConBaseOSDif ;
   private byte AV21es_base_OSDif ;
   private byte AV45diasMes ;
   private byte AV36auxLiqDCalculado ;
   private byte GXv_int3[] ;
   private short AV12EmpCod ;
   private short A1EmpCod ;
   private short AV70dias_vacaciones ;
   private short GXv_int4[] ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV13LiqNro ;
   private int AV71LiqRelNro ;
   private int AV14LegNumero ;
   private int A2112LiqRelNro ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal AV37Importes ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private java.math.BigDecimal A269LiqDCanti ;
   private java.math.BigDecimal AV52LiqDCanti ;
   private java.math.BigDecimal AV50horasSemanaNormal ;
   private java.math.BigDecimal AV51LegHorasSem ;
   private java.math.BigDecimal AV30LiqDImpCalcu ;
   private java.math.BigDecimal GXv_decimal7[] ;
   private java.math.BigDecimal GXv_decimal6[] ;
   private java.math.BigDecimal GXv_decimal13[] ;
   private java.math.BigDecimal AV76parcialLiqDImpCalcu ;
   private java.math.BigDecimal AV53porUnaje ;
   private java.math.BigDecimal AV57SueldoImportes ;
   private java.math.BigDecimal AV75parcialSueldoImportes ;
   private java.math.BigDecimal AV59adelantoVacImportes ;
   private java.math.BigDecimal AV77parcialVacImportes ;
   private java.math.BigDecimal AV66sacProporcionalImportes ;
   private java.math.BigDecimal AV67sacImportes ;
   private java.math.BigDecimal AV78parcialSacImportes ;
   private java.math.BigDecimal AV60topeSueldosImportes ;
   private java.math.BigDecimal AV64topeVacacionesImportes ;
   private java.math.BigDecimal AV68topeSACImportes ;
   private java.math.BigDecimal GXv_decimal14[] ;
   private java.math.BigDecimal AV73auxImportes ;
   private java.math.BigDecimal AV74auxTopeImportes ;
   private java.math.BigDecimal AV62baseImpLiqDImpCalcu ;
   private java.math.BigDecimal GXv_decimal17[] ;
   private java.math.BigDecimal AV83Importe ;
   private String AV61baseImpConCodigo ;
   private String AV27ProcesoLiquidacion ;
   private String AV8desdeTipoConCod ;
   private String AV9hastaTipoConCod ;
   private String AV10sueldoMensualConCodigo ;
   private String AV55subtipoSAC ;
   private String AV58subtipoVacaciones ;
   private String AV56subtipo2AdelantoVacaciones ;
   private String AV65subtipo2SACPropor ;
   private String AV81Pgmname ;
   private String AV20que ;
   private String scmdbuf ;
   private String A464DTipoConCod ;
   private String A394DConCodigo ;
   private String A732DSubTipoConCod2 ;
   private String A468DSubTipoConCod1 ;
   private String AV26nadaTLiqCod ;
   private String GXv_char1[] ;
   private String GXv_char8[] ;
   private String GXv_char9[] ;
   private String AV63baseAportesConCodigo ;
   private String GXt_char2 ;
   private String GXt_char19 ;
   private String GXv_char16[] ;
   private String GXv_char10[] ;
   private java.util.Date AV23LiqPeriodo ;
   private java.util.Date A397DLiqPeriodo ;
   private java.util.Date AV28date ;
   private boolean n2112LiqRelNro ;
   private boolean n732DSubTipoConCod2 ;
   private boolean n468DSubTipoConCod1 ;
   private boolean n269LiqDCanti ;
   private boolean AV15resolver ;
   private boolean AV16agregar ;
   private boolean AV54propAComp ;
   private boolean AV49MprEsParcial ;
   private boolean GXv_boolean5[] ;
   private boolean AV31dependenciasResueltas ;
   private boolean GXv_boolean11[] ;
   private boolean GXv_boolean12[] ;
   private boolean GXv_boolean15[] ;
   private boolean GXv_boolean18[] ;
   private boolean returnInSub ;
   private String AV35LiqDLog ;
   private String A504LiqDForOrig ;
   private String AV32auxLiqDLog ;
   private String AV34error ;
   private String A393DConDescrip ;
   private String AV29auxError ;
   private String[] aP11 ;
   private java.math.BigDecimal[] aP8 ;
   private byte[] aP9 ;
   private String[] aP10 ;
   private IDataStoreProvider pr_default ;
   private int[] P01PN2_A2112LiqRelNro ;
   private boolean[] P01PN2_n2112LiqRelNro ;
   private byte[] P01PN2_A1058LiqDFonSolRedCont ;
   private byte[] P01PN2_A1056LiqDObraSocCont ;
   private byte[] P01PN2_A1057LiqDFonSolRedApo ;
   private byte[] P01PN2_A1055LiqDObraSocApo ;
   private String[] P01PN2_A464DTipoConCod ;
   private int[] P01PN2_A6LegNumero ;
   private java.util.Date[] P01PN2_A397DLiqPeriodo ;
   private int[] P01PN2_A31LiqNro ;
   private short[] P01PN2_A1EmpCod ;
   private int[] P01PN2_A3CliCod ;
   private String[] P01PN2_A394DConCodigo ;
   private String[] P01PN2_A504LiqDForOrig ;
   private byte[] P01PN2_A507LiqDCalculado ;
   private String[] P01PN2_A393DConDescrip ;
   private java.math.BigDecimal[] P01PN2_A764LiqDImpReCalcu ;
   private String[] P01PN2_A732DSubTipoConCod2 ;
   private boolean[] P01PN2_n732DSubTipoConCod2 ;
   private String[] P01PN2_A468DSubTipoConCod1 ;
   private boolean[] P01PN2_n468DSubTipoConCod1 ;
   private java.math.BigDecimal[] P01PN2_A269LiqDCanti ;
   private boolean[] P01PN2_n269LiqDCanti ;
   private int[] P01PN2_A81LiqDSecuencial ;
}

final  class base_calculo_os_diferencial__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01PN2", "SELECT T2.LiqRelNro, T1.LiqDFonSolRedCont, T1.LiqDObraSocCont, T1.LiqDFonSolRedApo, T1.LiqDObraSocApo, T1.DTipoConCod, T1.LegNumero, T1.DLiqPeriodo, T1.LiqNro, T1.EmpCod, T1.CliCod, T1.DConCodigo, T1.LiqDForOrig, T1.LiqDCalculado, T1.DConDescrip, T1.LiqDImpReCalcu, T1.DSubTipoConCod2, T1.DSubTipoConCod1, T1.LiqDCanti, T1.LiqDSecuencial FROM (LiquidacionDetalle T1 INNER JOIN Liquidacion T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LiqNro = T1.LiqNro) WHERE (T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ?) AND (T1.LiqNro <= ?) AND (T1.DTipoConCod >= ( ?)) AND (T1.DTipoConCod <= ( ?)) AND (T1.LiqDObraSocApo = 1 or T1.LiqDFonSolRedApo = 1) AND (T1.LiqDObraSocCont = 1 or T1.LiqDFonSolRedCont = 1) AND (T2.LiqRelNro = ? or T2.LiqRelNro IS NULL) AND (T1.DLiqPeriodo = ?) ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((byte[]) buf[2])[0] = rslt.getByte(2);
               ((byte[]) buf[3])[0] = rslt.getByte(3);
               ((byte[]) buf[4])[0] = rslt.getByte(4);
               ((byte[]) buf[5])[0] = rslt.getByte(5);
               ((String[]) buf[6])[0] = rslt.getString(6, 20);
               ((int[]) buf[7])[0] = rslt.getInt(7);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(8);
               ((int[]) buf[9])[0] = rslt.getInt(9);
               ((short[]) buf[10])[0] = rslt.getShort(10);
               ((int[]) buf[11])[0] = rslt.getInt(11);
               ((String[]) buf[12])[0] = rslt.getString(12, 10);
               ((String[]) buf[13])[0] = rslt.getLongVarchar(13);
               ((byte[]) buf[14])[0] = rslt.getByte(14);
               ((String[]) buf[15])[0] = rslt.getVarchar(15);
               ((java.math.BigDecimal[]) buf[16])[0] = rslt.getBigDecimal(16,2);
               ((String[]) buf[17])[0] = rslt.getString(17, 20);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((String[]) buf[19])[0] = rslt.getString(18, 20);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(19,2);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((int[]) buf[23])[0] = rslt.getInt(20);
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setDate(8, (java.util.Date)parms[7]);
               return;
      }
   }

}

