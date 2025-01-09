package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class descuento_de_ley extends GXProcedure
{
   public descuento_de_ley( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( descuento_de_ley.class ), "" );
   }

   public descuento_de_ley( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           int aP2 ,
                                           int aP3 ,
                                           byte aP4 ,
                                           String aP5 ,
                                           String aP6 ,
                                           String aP7 ,
                                           java.util.Date aP8 ,
                                           String aP9 ,
                                           boolean aP10 ,
                                           String aP11 ,
                                           String aP12 ,
                                           boolean aP13 ,
                                           java.math.BigDecimal aP14 ,
                                           short aP15 ,
                                           short aP16 ,
                                           java.math.BigDecimal aP17 ,
                                           java.math.BigDecimal aP18 ,
                                           byte aP19 ,
                                           java.math.BigDecimal[] aP20 ,
                                           java.math.BigDecimal[] aP21 ,
                                           String[] aP22 ,
                                           String[] aP23 ,
                                           byte[] aP24 )
   {
      descuento_de_ley.this.aP25 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21, aP22, aP23, aP24, aP25);
      return aP25[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        byte aP4 ,
                        String aP5 ,
                        String aP6 ,
                        String aP7 ,
                        java.util.Date aP8 ,
                        String aP9 ,
                        boolean aP10 ,
                        String aP11 ,
                        String aP12 ,
                        boolean aP13 ,
                        java.math.BigDecimal aP14 ,
                        short aP15 ,
                        short aP16 ,
                        java.math.BigDecimal aP17 ,
                        java.math.BigDecimal aP18 ,
                        byte aP19 ,
                        java.math.BigDecimal[] aP20 ,
                        java.math.BigDecimal[] aP21 ,
                        String[] aP22 ,
                        String[] aP23 ,
                        byte[] aP24 ,
                        java.math.BigDecimal[] aP25 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21, aP22, aP23, aP24, aP25);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             byte aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String aP7 ,
                             java.util.Date aP8 ,
                             String aP9 ,
                             boolean aP10 ,
                             String aP11 ,
                             String aP12 ,
                             boolean aP13 ,
                             java.math.BigDecimal aP14 ,
                             short aP15 ,
                             short aP16 ,
                             java.math.BigDecimal aP17 ,
                             java.math.BigDecimal aP18 ,
                             byte aP19 ,
                             java.math.BigDecimal[] aP20 ,
                             java.math.BigDecimal[] aP21 ,
                             String[] aP22 ,
                             String[] aP23 ,
                             byte[] aP24 ,
                             java.math.BigDecimal[] aP25 )
   {
      descuento_de_ley.this.AV11CliCod = aP0;
      descuento_de_ley.this.AV24EmpCod = aP1;
      descuento_de_ley.this.AV25LiqNro = aP2;
      descuento_de_ley.this.AV9LegNumero = aP3;
      descuento_de_ley.this.AV52LegClase = aP4;
      descuento_de_ley.this.AV62LegModTra = aP5;
      descuento_de_ley.this.AV61parmSinCod = aP6;
      descuento_de_ley.this.AV38ConCodigo = aP7;
      descuento_de_ley.this.AV22LiqPeriodo = aP8;
      descuento_de_ley.this.AV12ProcesoLiquidacion = aP9;
      descuento_de_ley.this.AV13insertandoConceptos = aP10;
      descuento_de_ley.this.AV10baseConCodigo = aP11;
      descuento_de_ley.this.AV21OpeCliId = aP12;
      descuento_de_ley.this.AV44cuotaSindicalEs = aP13;
      descuento_de_ley.this.AV56parm_RemuImportes = aP14;
      descuento_de_ley.this.AV54parm_cntRemu = aP15;
      descuento_de_ley.this.AV55parm_CntTrab = aP16;
      descuento_de_ley.this.AV31base_imp_max = aP17;
      descuento_de_ley.this.AV60base_imp_min = aP18;
      descuento_de_ley.this.AV49cantDiasMes = aP19;
      descuento_de_ley.this.aP20 = aP20;
      descuento_de_ley.this.aP21 = aP21;
      descuento_de_ley.this.aP22 = aP22;
      descuento_de_ley.this.aP23 = aP23;
      descuento_de_ley.this.aP24 = aP24;
      descuento_de_ley.this.aP25 = aP25;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8LiqDCalculado = (byte)(1) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV65Pgmname, httpContext.getMessage( "&parm_CntTrab ", "")+GXutil.trim( GXutil.str( AV55parm_CntTrab, 4, 0))) ;
      if ( ! (GXutil.strcmp("", AV10baseConCodigo)==0) )
      {
         GXv_decimal1[0] = AV14baseLiqDImpCalcu ;
         GXv_boolean2[0] = AV39baseImponibleExiste ;
         GXv_int3[0] = AV16auxLiqDCalculado ;
         new web.getliqdimpcalcu(remoteHandle, context).execute( AV11CliCod, AV24EmpCod, AV25LiqNro, AV9LegNumero, AV10baseConCodigo, AV12ProcesoLiquidacion, AV13insertandoConceptos, GXv_decimal1, GXv_boolean2, GXv_int3) ;
         descuento_de_ley.this.AV14baseLiqDImpCalcu = GXv_decimal1[0] ;
         descuento_de_ley.this.AV39baseImponibleExiste = GXv_boolean2[0] ;
         descuento_de_ley.this.AV16auxLiqDCalculado = GXv_int3[0] ;
      }
      if ( ! AV39baseImponibleExiste )
      {
         AV35desdeTipoConCod = "REM_ARG" ;
         AV32sueldoImportes = AV56parm_RemuImportes ;
         AV50cntSueldo = AV54parm_cntRemu ;
         AV40LiqDCanti = DecimalUtil.doubleToDec(AV55parm_CntTrab) ;
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV40LiqDCanti)==0) )
         {
            AV58txtTrabajados = httpContext.getMessage( "Inicializa con ", "") + GXutil.trim( GXutil.str( AV40LiqDCanti, 14, 2)) ;
         }
         if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV32sueldoImportes)==0) )
         {
            AV34hastaTipoConCod = "REM_ARG" ;
            /* Using cursor P01EG2 */
            pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV24EmpCod), Integer.valueOf(AV25LiqNro), Integer.valueOf(AV9LegNumero), AV35desdeTipoConCod});
            while ( (pr_default.getStatus(0) != 101) )
            {
               A464DTipoConCod = P01EG2_A464DTipoConCod[0] ;
               A6LegNumero = P01EG2_A6LegNumero[0] ;
               A31LiqNro = P01EG2_A31LiqNro[0] ;
               A1EmpCod = P01EG2_A1EmpCod[0] ;
               A3CliCod = P01EG2_A3CliCod[0] ;
               A394DConCodigo = P01EG2_A394DConCodigo[0] ;
               A507LiqDCalculado = P01EG2_A507LiqDCalculado[0] ;
               A763LiqDRecalculado = P01EG2_A763LiqDRecalculado[0] ;
               A393DConDescrip = P01EG2_A393DConDescrip[0] ;
               A275LiqDImpCalcu = P01EG2_A275LiqDImpCalcu[0] ;
               n275LiqDImpCalcu = P01EG2_n275LiqDImpCalcu[0] ;
               A269LiqDCanti = P01EG2_A269LiqDCanti[0] ;
               n269LiqDCanti = P01EG2_n269LiqDCanti[0] ;
               A1487DConCondicion = P01EG2_A1487DConCondicion[0] ;
               A468DSubTipoConCod1 = P01EG2_A468DSubTipoConCod1[0] ;
               n468DSubTipoConCod1 = P01EG2_n468DSubTipoConCod1[0] ;
               A81LiqDSecuencial = P01EG2_A81LiqDSecuencial[0] ;
               GXv_int3[0] = AV16auxLiqDCalculado ;
               new web.dependenciaresuelta2(remoteHandle, context).execute( AV11CliCod, A394DConCodigo, AV12ProcesoLiquidacion, A507LiqDCalculado, A763LiqDRecalculado, GXv_int3) ;
               descuento_de_ley.this.AV16auxLiqDCalculado = GXv_int3[0] ;
               if ( AV16auxLiqDCalculado == 0 )
               {
                  AV8LiqDCalculado = (byte)(0) ;
                  AV17error = httpContext.getMessage( "_Falta calcular ", "") + GXutil.trim( A393DConDescrip) ;
                  AV18LiqDLog = GXutil.trim( AV17error) ;
                  pr_default.close(0);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               AV32sueldoImportes = AV32sueldoImportes.add(A275LiqDImpCalcu) ;
               AV50cntSueldo = (short)(AV50cntSueldo+1) ;
               if ( A275LiqDImpCalcu.doubleValue() > 0 )
               {
                  AV40LiqDCanti = AV40LiqDCanti.add(A269LiqDCanti) ;
                  AV58txtTrabajados += httpContext.getMessage( ". Suma ", "") + GXutil.trim( GXutil.str( A269LiqDCanti, 14, 2)) + httpContext.getMessage( " de ", "") + GXutil.trim( A393DConDescrip) ;
               }
               else
               {
                  GXv_boolean2[0] = AV59restar ;
                  new web.restardiaseguncondicionytipo(remoteHandle, context).execute( A1487DConCondicion, A464DTipoConCod, A468DSubTipoConCod1, GXv_boolean2) ;
                  descuento_de_ley.this.AV59restar = GXv_boolean2[0] ;
                  if ( AV59restar )
                  {
                     AV40LiqDCanti = AV40LiqDCanti.subtract(A269LiqDCanti) ;
                     AV58txtTrabajados += httpContext.getMessage( ". Resta ", "") + GXutil.trim( GXutil.str( A269LiqDCanti, 14, 2)) + httpContext.getMessage( " de ", "") + GXutil.trim( A393DConDescrip) ;
                  }
               }
               pr_default.readNext(0);
            }
            pr_default.close(0);
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV65Pgmname, httpContext.getMessage( "&LegClase ", "")+GXutil.trim( GXutil.str( AV52LegClase, 1, 0))) ;
         if ( ( AV52LegClase == 1 ) && ( GXutil.strcmp(AV62LegModTra, "E") == 0 ) && ! AV44cuotaSindicalEs && ( AV50cntSueldo > 1 ) )
         {
            if ( AV40LiqDCanti.doubleValue() < AV49cantDiasMes )
            {
               AV31base_imp_max = AV31base_imp_max.divide(DecimalUtil.doubleToDec(AV49cantDiasMes), 18, java.math.RoundingMode.DOWN) ;
               AV31base_imp_max = AV31base_imp_max.multiply(AV40LiqDCanti) ;
               AV51prporcionEs = true ;
               AV60base_imp_min = AV60base_imp_min.divide(DecimalUtil.doubleToDec(AV49cantDiasMes), 18, java.math.RoundingMode.DOWN) ;
               AV60base_imp_min = AV60base_imp_min.multiply(AV40LiqDCanti) ;
            }
         }
         else
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV65Pgmname, httpContext.getMessage( "es jornal?", "")) ;
            if ( ( AV52LegClase != 1 ) || ( GXutil.strcmp(AV62LegModTra, "E") != 0 ) )
            {
               AV31base_imp_max = AV31base_imp_max.divide(DecimalUtil.doubleToDec(2), 18, java.math.RoundingMode.DOWN) ;
               AV60base_imp_min = AV60base_imp_min.divide(DecimalUtil.doubleToDec(2), 18, java.math.RoundingMode.DOWN) ;
               AV40LiqDCanti = DecimalUtil.doubleToDec(15) ;
               AV58txtTrabajados = httpContext.getMessage( "Asigna 15 días de quincena", "") ;
               AV51prporcionEs = true ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV65Pgmname, httpContext.getMessage( "sí", "")) ;
            }
         }
         if ( DecimalUtil.compareTo(AV32sueldoImportes, AV60base_imp_min) < 0 )
         {
            AV18LiqDLog = httpContext.getMessage( "Inicializa valor con mínimo imponible ", "") + GXutil.trim( GXutil.str( AV60base_imp_min, 14, 2)) ;
            if ( AV51prporcionEs )
            {
               GXv_char4[0] = AV57tooltipTrabajados ;
               new web.armatooltip(remoteHandle, context).execute( AV11CliCod, AV40LiqDCanti, AV58txtTrabajados, false, GXv_char4) ;
               descuento_de_ley.this.AV57tooltipTrabajados = GXv_char4[0] ;
               AV18LiqDLog += httpContext.getMessage( " proporcionado a ", "") + GXutil.trim( AV57tooltipTrabajados) + httpContext.getMessage( " días trabajados", "") ;
            }
            AV19Importes = AV60base_imp_min ;
         }
         else
         {
            if ( ( DecimalUtil.compareTo(AV32sueldoImportes, AV31base_imp_max) < 0 ) || ( AV44cuotaSindicalEs ) )
            {
               AV18LiqDLog = httpContext.getMessage( "Inicializa valor con sueldo ", "") + GXutil.trim( GXutil.str( AV32sueldoImportes, 14, 2)) ;
               AV19Importes = AV32sueldoImportes ;
            }
            else
            {
               AV18LiqDLog = httpContext.getMessage( "Inicializa valor con máximo imponible ", "") + GXutil.trim( GXutil.str( AV31base_imp_max, 14, 2)) ;
               if ( AV51prporcionEs )
               {
                  GXv_char4[0] = AV57tooltipTrabajados ;
                  new web.armatooltip(remoteHandle, context).execute( AV11CliCod, AV40LiqDCanti, AV58txtTrabajados, false, GXv_char4) ;
                  descuento_de_ley.this.AV57tooltipTrabajados = GXv_char4[0] ;
                  AV18LiqDLog += httpContext.getMessage( " proporcionado a ", "") + GXutil.trim( AV57tooltipTrabajados) + httpContext.getMessage( " días trabajados", "") ;
               }
               AV19Importes = AV31base_imp_max ;
            }
         }
         AV14baseLiqDImpCalcu = AV19Importes ;
      }
      else
      {
         if ( ! AV44cuotaSindicalEs )
         {
            if ( AV16auxLiqDCalculado == 0 )
            {
               AV8LiqDCalculado = (byte)(0) ;
               AV17error = httpContext.getMessage( "Falta calcular concepto ", "") + GXutil.trim( AV10baseConCodigo) ;
               AV18LiqDLog = GXutil.trim( AV17error) ;
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            AV18LiqDLog = httpContext.getMessage( "Inicializa valor con ", "") + GXutil.trim( GXutil.str( AV14baseLiqDImpCalcu, 14, 2)) + httpContext.getMessage( " de concepto ", "") + GXutil.trim( AV10baseConCodigo) ;
            AV19Importes = AV14baseLiqDImpCalcu ;
         }
         else
         {
            GXv_decimal1[0] = AV19Importes ;
            GXv_int3[0] = AV16auxLiqDCalculado ;
            new web.getimpliqportipo(remoteHandle, context).execute( AV11CliCod, AV24EmpCod, AV25LiqNro, AV9LegNumero, AV22LiqPeriodo, "REM_ARG", AV38ConCodigo, AV12ProcesoLiquidacion, AV45dummy_collection, GXv_decimal1, GXv_int3) ;
            descuento_de_ley.this.AV19Importes = GXv_decimal1[0] ;
            descuento_de_ley.this.AV16auxLiqDCalculado = GXv_int3[0] ;
            if ( AV16auxLiqDCalculado == 0 )
            {
               AV8LiqDCalculado = (byte)(0) ;
               AV17error = httpContext.getMessage( "Faltan dependencias de conceptos remunerativos", "") ;
               AV18LiqDLog = GXutil.trim( AV17error) ;
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            AV18LiqDLog = httpContext.getMessage( "Inicializa valor con ", "") + GXutil.trim( GXutil.str( AV19Importes, 14, 2)) + httpContext.getMessage( " de conceptos remunerativos.", "") ;
         }
      }
      AV28constantes_default = AV21OpeCliId ;
      if ( ! AV44cuotaSindicalEs )
      {
         GXv_char4[0] = AV23OpeCliValor ;
         GXv_char5[0] = AV26auxError ;
         new web.getopeclivalor(remoteHandle, context).execute( AV11CliCod, AV21OpeCliId, AV22LiqPeriodo, AV12ProcesoLiquidacion, GXv_char4, GXv_char5) ;
         descuento_de_ley.this.AV23OpeCliValor = GXv_char4[0] ;
         descuento_de_ley.this.AV26auxError = GXv_char5[0] ;
         if ( ! (GXutil.strcmp("", AV26auxError)==0) )
         {
            AV8LiqDCalculado = (byte)(0) ;
            AV17error = AV26auxError ;
            AV18LiqDLog = AV17error ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV20porUnaje = CommonUtil.decimalVal( AV23OpeCliValor, ".") ;
         AV47alicuotaDescripcion = GXutil.trim( httpContext.getMessage( web.gxdomainconstantes_default.getDescription(httpContext,(String)AV28constantes_default), "")) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV61parmSinCod)==0) )
         {
            AV46SinCod = AV61parmSinCod ;
         }
         else
         {
            GXv_char5[0] = AV46SinCod ;
            new web.empleadogetsindicato(remoteHandle, context).execute( AV11CliCod, AV24EmpCod, AV9LegNumero, GXv_char5) ;
            descuento_de_ley.this.AV46SinCod = GXv_char5[0] ;
         }
         GXv_decimal1[0] = AV20porUnaje ;
         GXv_boolean2[0] = false ;
         new web.getsindicatocuota(remoteHandle, context).execute( AV11CliCod, AV46SinCod, GXv_decimal1, GXv_boolean2) ;
         descuento_de_ley.this.AV20porUnaje = GXv_decimal1[0] ;
         AV48operandos = "[alicuota_sindical]" ;
         AV47alicuotaDescripcion = GXutil.trim( httpContext.getMessage( web.gxdomainoperandos.getDescription(httpContext,(String)AV48operandos), "")) ;
      }
      AV19Importes = AV19Importes.multiply(AV20porUnaje) ;
      AV18LiqDLog += httpContext.getMessage( ". Se multiplica por ", "") + GXutil.trim( GXutil.str( AV20porUnaje, 6, 4)) + httpContext.getMessage( " de ", "") + GXutil.trim( AV47alicuotaDescripcion) ;
      AV43cantidadCalculada = AV20porUnaje.multiply(DecimalUtil.doubleToDec(100)) ;
      if ( AV44cuotaSindicalEs )
      {
         AV14baseLiqDImpCalcu = AV32sueldoImportes ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP20[0] = descuento_de_ley.this.AV19Importes;
      this.aP21[0] = descuento_de_ley.this.AV14baseLiqDImpCalcu;
      this.aP22[0] = descuento_de_ley.this.AV17error;
      this.aP23[0] = descuento_de_ley.this.AV18LiqDLog;
      this.aP24[0] = descuento_de_ley.this.AV8LiqDCalculado;
      this.aP25[0] = descuento_de_ley.this.AV43cantidadCalculada;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV19Importes = DecimalUtil.ZERO ;
      AV14baseLiqDImpCalcu = DecimalUtil.ZERO ;
      AV17error = "" ;
      AV18LiqDLog = "" ;
      AV43cantidadCalculada = DecimalUtil.ZERO ;
      AV65Pgmname = "" ;
      AV35desdeTipoConCod = "" ;
      AV32sueldoImportes = DecimalUtil.ZERO ;
      AV40LiqDCanti = DecimalUtil.ZERO ;
      AV58txtTrabajados = "" ;
      AV34hastaTipoConCod = "" ;
      scmdbuf = "" ;
      P01EG2_A464DTipoConCod = new String[] {""} ;
      P01EG2_A6LegNumero = new int[1] ;
      P01EG2_A31LiqNro = new int[1] ;
      P01EG2_A1EmpCod = new short[1] ;
      P01EG2_A3CliCod = new int[1] ;
      P01EG2_A394DConCodigo = new String[] {""} ;
      P01EG2_A507LiqDCalculado = new byte[1] ;
      P01EG2_A763LiqDRecalculado = new short[1] ;
      P01EG2_A393DConDescrip = new String[] {""} ;
      P01EG2_A275LiqDImpCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01EG2_n275LiqDImpCalcu = new boolean[] {false} ;
      P01EG2_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01EG2_n269LiqDCanti = new boolean[] {false} ;
      P01EG2_A1487DConCondicion = new String[] {""} ;
      P01EG2_A468DSubTipoConCod1 = new String[] {""} ;
      P01EG2_n468DSubTipoConCod1 = new boolean[] {false} ;
      P01EG2_A81LiqDSecuencial = new int[1] ;
      A464DTipoConCod = "" ;
      A394DConCodigo = "" ;
      A393DConDescrip = "" ;
      A275LiqDImpCalcu = DecimalUtil.ZERO ;
      A269LiqDCanti = DecimalUtil.ZERO ;
      A1487DConCondicion = "" ;
      A468DSubTipoConCod1 = "" ;
      AV57tooltipTrabajados = "" ;
      AV45dummy_collection = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_int3 = new byte[1] ;
      AV28constantes_default = "" ;
      AV23OpeCliValor = "" ;
      GXv_char4 = new String[1] ;
      AV26auxError = "" ;
      AV20porUnaje = DecimalUtil.ZERO ;
      AV47alicuotaDescripcion = "" ;
      AV46SinCod = "" ;
      GXv_char5 = new String[1] ;
      GXv_decimal1 = new java.math.BigDecimal[1] ;
      GXv_boolean2 = new boolean[1] ;
      AV48operandos = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.descuento_de_ley__default(),
         new Object[] {
             new Object[] {
            P01EG2_A464DTipoConCod, P01EG2_A6LegNumero, P01EG2_A31LiqNro, P01EG2_A1EmpCod, P01EG2_A3CliCod, P01EG2_A394DConCodigo, P01EG2_A507LiqDCalculado, P01EG2_A763LiqDRecalculado, P01EG2_A393DConDescrip, P01EG2_A275LiqDImpCalcu,
            P01EG2_n275LiqDImpCalcu, P01EG2_A269LiqDCanti, P01EG2_n269LiqDCanti, P01EG2_A1487DConCondicion, P01EG2_A468DSubTipoConCod1, P01EG2_n468DSubTipoConCod1, P01EG2_A81LiqDSecuencial
            }
         }
      );
      AV65Pgmname = "descuento_de_ley" ;
      /* GeneXus formulas. */
      AV65Pgmname = "descuento_de_ley" ;
      Gx_err = (short)(0) ;
   }

   private byte AV52LegClase ;
   private byte AV49cantDiasMes ;
   private byte AV8LiqDCalculado ;
   private byte AV16auxLiqDCalculado ;
   private byte A507LiqDCalculado ;
   private byte GXv_int3[] ;
   private short AV24EmpCod ;
   private short AV54parm_cntRemu ;
   private short AV55parm_CntTrab ;
   private short AV50cntSueldo ;
   private short A1EmpCod ;
   private short A763LiqDRecalculado ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV25LiqNro ;
   private int AV9LegNumero ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal AV56parm_RemuImportes ;
   private java.math.BigDecimal AV31base_imp_max ;
   private java.math.BigDecimal AV60base_imp_min ;
   private java.math.BigDecimal AV19Importes ;
   private java.math.BigDecimal AV14baseLiqDImpCalcu ;
   private java.math.BigDecimal AV43cantidadCalculada ;
   private java.math.BigDecimal AV32sueldoImportes ;
   private java.math.BigDecimal AV40LiqDCanti ;
   private java.math.BigDecimal A275LiqDImpCalcu ;
   private java.math.BigDecimal A269LiqDCanti ;
   private java.math.BigDecimal AV20porUnaje ;
   private java.math.BigDecimal GXv_decimal1[] ;
   private String AV62LegModTra ;
   private String AV61parmSinCod ;
   private String AV38ConCodigo ;
   private String AV12ProcesoLiquidacion ;
   private String AV10baseConCodigo ;
   private String AV21OpeCliId ;
   private String AV65Pgmname ;
   private String AV35desdeTipoConCod ;
   private String AV34hastaTipoConCod ;
   private String scmdbuf ;
   private String A464DTipoConCod ;
   private String A394DConCodigo ;
   private String A1487DConCondicion ;
   private String A468DSubTipoConCod1 ;
   private String AV28constantes_default ;
   private String GXv_char4[] ;
   private String AV46SinCod ;
   private String GXv_char5[] ;
   private String AV48operandos ;
   private java.util.Date AV22LiqPeriodo ;
   private boolean AV13insertandoConceptos ;
   private boolean AV44cuotaSindicalEs ;
   private boolean AV39baseImponibleExiste ;
   private boolean n275LiqDImpCalcu ;
   private boolean n269LiqDCanti ;
   private boolean n468DSubTipoConCod1 ;
   private boolean returnInSub ;
   private boolean AV59restar ;
   private boolean AV51prporcionEs ;
   private boolean GXv_boolean2[] ;
   private String AV18LiqDLog ;
   private String AV23OpeCliValor ;
   private String AV17error ;
   private String AV58txtTrabajados ;
   private String A393DConDescrip ;
   private String AV57tooltipTrabajados ;
   private String AV26auxError ;
   private String AV47alicuotaDescripcion ;
   private java.math.BigDecimal[] aP25 ;
   private java.math.BigDecimal[] aP20 ;
   private java.math.BigDecimal[] aP21 ;
   private String[] aP22 ;
   private String[] aP23 ;
   private byte[] aP24 ;
   private IDataStoreProvider pr_default ;
   private String[] P01EG2_A464DTipoConCod ;
   private int[] P01EG2_A6LegNumero ;
   private int[] P01EG2_A31LiqNro ;
   private short[] P01EG2_A1EmpCod ;
   private int[] P01EG2_A3CliCod ;
   private String[] P01EG2_A394DConCodigo ;
   private byte[] P01EG2_A507LiqDCalculado ;
   private short[] P01EG2_A763LiqDRecalculado ;
   private String[] P01EG2_A393DConDescrip ;
   private java.math.BigDecimal[] P01EG2_A275LiqDImpCalcu ;
   private boolean[] P01EG2_n275LiqDImpCalcu ;
   private java.math.BigDecimal[] P01EG2_A269LiqDCanti ;
   private boolean[] P01EG2_n269LiqDCanti ;
   private String[] P01EG2_A1487DConCondicion ;
   private String[] P01EG2_A468DSubTipoConCod1 ;
   private boolean[] P01EG2_n468DSubTipoConCod1 ;
   private int[] P01EG2_A81LiqDSecuencial ;
   private GXSimpleCollection<String> AV45dummy_collection ;
}

final  class descuento_de_ley__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01EG2", "SELECT DTipoConCod, LegNumero, LiqNro, EmpCod, CliCod, DConCodigo, LiqDCalculado, LiqDRecalculado, DConDescrip, LiqDImpCalcu, LiqDCanti, DConCondicion, DSubTipoConCod1, LiqDSecuencial FROM LiquidacionDetalle WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? and DTipoConCod = ( ?) ORDER BY CliCod, EmpCod, LiqNro, LegNumero, DTipoConCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 10);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,2);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(11,2);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getString(12, 20);
               ((String[]) buf[14])[0] = rslt.getString(13, 20);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((int[]) buf[16])[0] = rslt.getInt(14);
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
               return;
      }
   }

}

