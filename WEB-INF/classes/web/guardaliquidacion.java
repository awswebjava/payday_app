package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class guardaliquidacion extends GXProcedure
{
   public guardaliquidacion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( guardaliquidacion.class ), "" );
   }

   public guardaliquidacion( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              java.util.Date aP3 ,
                              java.util.Date aP4 ,
                              String aP5 ,
                              byte aP6 ,
                              String aP7 ,
                              byte aP8 ,
                              String aP9 ,
                              java.util.Date aP10 ,
                              java.util.Date aP11 ,
                              byte aP12 ,
                              String aP13 ,
                              String aP14 ,
                              GXSimpleCollection<Integer> aP15 ,
                              String aP16 ,
                              java.util.Date aP17 ,
                              short aP18 ,
                              byte aP19 ,
                              byte aP20 ,
                              short aP21 ,
                              boolean aP22 ,
                              java.util.Date aP23 ,
                              String aP24 ,
                              String aP25 ,
                              int aP26 ,
                              String aP27 ,
                              String aP28 ,
                              java.math.BigDecimal aP29 ,
                              String aP30 ,
                              boolean aP31 ,
                              String aP32 ,
                              String aP33 ,
                              boolean aP34 )
   {
      guardaliquidacion.this.aP35 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21, aP22, aP23, aP24, aP25, aP26, aP27, aP28, aP29, aP30, aP31, aP32, aP33, aP34, aP35);
      return aP35[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        java.util.Date aP4 ,
                        String aP5 ,
                        byte aP6 ,
                        String aP7 ,
                        byte aP8 ,
                        String aP9 ,
                        java.util.Date aP10 ,
                        java.util.Date aP11 ,
                        byte aP12 ,
                        String aP13 ,
                        String aP14 ,
                        GXSimpleCollection<Integer> aP15 ,
                        String aP16 ,
                        java.util.Date aP17 ,
                        short aP18 ,
                        byte aP19 ,
                        byte aP20 ,
                        short aP21 ,
                        boolean aP22 ,
                        java.util.Date aP23 ,
                        String aP24 ,
                        String aP25 ,
                        int aP26 ,
                        String aP27 ,
                        String aP28 ,
                        java.math.BigDecimal aP29 ,
                        String aP30 ,
                        boolean aP31 ,
                        String aP32 ,
                        String aP33 ,
                        boolean aP34 ,
                        boolean[] aP35 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21, aP22, aP23, aP24, aP25, aP26, aP27, aP28, aP29, aP30, aP31, aP32, aP33, aP34, aP35);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             java.util.Date aP4 ,
                             String aP5 ,
                             byte aP6 ,
                             String aP7 ,
                             byte aP8 ,
                             String aP9 ,
                             java.util.Date aP10 ,
                             java.util.Date aP11 ,
                             byte aP12 ,
                             String aP13 ,
                             String aP14 ,
                             GXSimpleCollection<Integer> aP15 ,
                             String aP16 ,
                             java.util.Date aP17 ,
                             short aP18 ,
                             byte aP19 ,
                             byte aP20 ,
                             short aP21 ,
                             boolean aP22 ,
                             java.util.Date aP23 ,
                             String aP24 ,
                             String aP25 ,
                             int aP26 ,
                             String aP27 ,
                             String aP28 ,
                             java.math.BigDecimal aP29 ,
                             String aP30 ,
                             boolean aP31 ,
                             String aP32 ,
                             String aP33 ,
                             boolean aP34 ,
                             boolean[] aP35 )
   {
      guardaliquidacion.this.AV37CliCod = aP0;
      guardaliquidacion.this.AV9EmpCod = aP1;
      guardaliquidacion.this.AV14LiqNro = aP2;
      guardaliquidacion.this.AV13LiqFecha = aP3;
      guardaliquidacion.this.AV42LiqFecPago = aP4;
      guardaliquidacion.this.AV11LiqDescrip = aP5;
      guardaliquidacion.this.AV10LiqClase = aP6;
      guardaliquidacion.this.AV178LiqModTra = aP7;
      guardaliquidacion.this.AV177LiqFrecPag = aP8;
      guardaliquidacion.this.AV180LiqTipoTarifa = aP9;
      guardaliquidacion.this.AV176LiqPerDes = aP10;
      guardaliquidacion.this.AV175LiqPerHas = aP11;
      guardaliquidacion.this.AV12LiqEstado = aP12;
      guardaliquidacion.this.AV24TliqCod = aP13;
      guardaliquidacion.this.AV34AplicaA = aP14;
      guardaliquidacion.this.AV35LegNumero = aP15;
      guardaliquidacion.this.AV43LiqDepBanCod = aP16;
      guardaliquidacion.this.AV44LiqDepPrvFec = aP17;
      guardaliquidacion.this.AV45LiqDepPerAno = aP18;
      guardaliquidacion.this.AV46LiqDepPerMes = aP19;
      guardaliquidacion.this.AV47LiqPerMes = aP20;
      guardaliquidacion.this.AV48LiqPerAno = aP21;
      guardaliquidacion.this.AV33final = aP22;
      guardaliquidacion.this.AV50LiqFecImp = aP23;
      guardaliquidacion.this.AV96parmLiqPerPalabra = aP24;
      guardaliquidacion.this.AV60LiqNombre = aP25;
      guardaliquidacion.this.AV116LiqRelNro = aP26;
      guardaliquidacion.this.AV119parmLiqLegConvenio = aP27;
      guardaliquidacion.this.AV118parmLiqLegCatCodigo = aP28;
      guardaliquidacion.this.AV120parmLiqLegSueldo = aP29;
      guardaliquidacion.this.AV123clientId = aP30;
      guardaliquidacion.this.AV133LiqSac = aP31;
      guardaliquidacion.this.AV132LiqSacLog = aP32;
      guardaliquidacion.this.AV155daemonUUID = aP33;
      guardaliquidacion.this.AV173reLiquidacion = aP34;
      guardaliquidacion.this.aP35 = aP35;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod2(remoteHandle, context).execute( AV37CliCod, AV183Pgmname, "1") ;
      GXt_char1 = AV163liqRecibosModoPalabra ;
      GXt_char2 = AV163liqRecibosModoPalabra ;
      GXv_char3[0] = GXt_char2 ;
      new web.liq_modo2_codigoparam(remoteHandle, context).execute( "liq_modo_recibos", GXv_char3) ;
      guardaliquidacion.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV37CliCod, GXt_char2, GXv_char4) ;
      guardaliquidacion.this.GXt_char1 = GXv_char4[0] ;
      AV163liqRecibosModoPalabra = GXt_char1 ;
      GXt_char2 = AV161liqDepLSDModoPalabra ;
      GXt_char1 = AV161liqDepLSDModoPalabra ;
      GXv_char4[0] = GXt_char1 ;
      new web.liq_modo2_codigoparam(remoteHandle, context).execute( "liq_modo_lsd", GXv_char4) ;
      guardaliquidacion.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV37CliCod, GXt_char1, GXv_char3) ;
      guardaliquidacion.this.GXt_char2 = GXv_char3[0] ;
      AV161liqDepLSDModoPalabra = GXt_char2 ;
      AV137LiqLote = com.genexus.util.Encryption.getNewKey( ) ;
      GXv_char4[0] = AV92ParmValue ;
      new web.getparametro(remoteHandle, context).execute( AV37CliCod, new web.lambda_desgloce_codigo(remoteHandle, context).executeUdp( ), GXv_char4) ;
      guardaliquidacion.this.AV92ParmValue = GXv_char4[0] ;
      AV157desgloceEs = GXutil.boolval( AV92ParmValue) ;
      GXv_boolean5[0] = AV160GenRec_RestLocHab ;
      GXv_objcol_int6[0] = AV167RestLocRNro ;
      new web.getrest_lochabyreplicas(remoteHandle, context).execute( AV37CliCod, httpContext.getMessage( "GenRecibos", ""), GXv_boolean5, GXv_objcol_int6) ;
      guardaliquidacion.this.AV160GenRec_RestLocHab = GXv_boolean5[0] ;
      AV167RestLocRNro = GXv_objcol_int6[0] ;
      GXv_char4[0] = AV168sqsGenPdfsURL ;
      new web.getparametro(remoteHandle, context).execute( AV37CliCod, new web.url_sqs_generarrecibos_codigoparam(remoteHandle, context).executeUdp( ), GXv_char4) ;
      guardaliquidacion.this.AV168sqsGenPdfsURL = GXv_char4[0] ;
      GXv_char4[0] = AV174sqsDepLSDURL ;
      new web.getparametro(remoteHandle, context).execute( AV37CliCod, new web.url_sqs_deplsd_codigoparam(remoteHandle, context).executeUdp( ), GXv_char4) ;
      guardaliquidacion.this.AV174sqsDepLSDURL = GXv_char4[0] ;
      GXv_char4[0] = AV159flujoGenRecPalabra ;
      new web.getparametroflujogenrec(remoteHandle, context).execute( AV37CliCod, GXv_char4) ;
      guardaliquidacion.this.AV159flujoGenRecPalabra = GXv_char4[0] ;
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV50LiqFecImp) )
      {
         GXv_date7[0] = AV54LiqPeriodo ;
         new web.newliquidacioncabecera(remoteHandle, context).execute( AV37CliCod, AV9EmpCod, AV14LiqNro, AV48LiqPerAno, AV47LiqPerMes, AV96parmLiqPerPalabra, AV11LiqDescrip, AV13LiqFecha, AV10LiqClase, AV178LiqModTra, AV177LiqFrecPag, AV180LiqTipoTarifa, AV176LiqPerDes, AV175LiqPerHas, AV42LiqFecPago, AV24TliqCod, AV12LiqEstado, AV12LiqEstado, AV34AplicaA, AV43LiqDepBanCod, AV44LiqDepPrvFec, AV45LiqDepPerAno, AV46LiqDepPerMes, AV50LiqFecImp, AV60LiqNombre, AV116LiqRelNro, AV133LiqSac, AV132LiqSacLog, (short)(AV35LegNumero.size()), GXv_date7) ;
         guardaliquidacion.this.AV54LiqPeriodo = GXv_date7[0] ;
      }
      GXt_char2 = AV92ParmValue ;
      GXt_char1 = AV92ParmValue ;
      GXv_char4[0] = GXt_char1 ;
      new web.liquidarauxparalelos_param(remoteHandle, context).execute( GXv_char4) ;
      guardaliquidacion.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV37CliCod, GXt_char1, GXv_char3) ;
      guardaliquidacion.this.GXt_char2 = GXv_char3[0] ;
      AV92ParmValue = GXt_char2 ;
      if ( (GXutil.strcmp("", AV92ParmValue)==0) )
      {
         AV92ParmValue = httpContext.getMessage( "false", "") ;
      }
      AV100segundoPlano = GXutil.boolval( AV92ParmValue) ;
      AV54LiqPeriodo = localUtil.ymdtod( AV48LiqPerAno, AV47LiqPerMes, 1) ;
      AV109GeneralConceptosOK = true ;
      GXv_int8[0] = AV125PaiCod ;
      new web.clientegetpais(remoteHandle, context).execute( AV37CliCod, GXv_int8) ;
      guardaliquidacion.this.AV125PaiCod = GXv_int8[0] ;
      GXv_char4[0] = AV126remuTipoConCod ;
      GXv_char3[0] = AV127noRemuTipoConCod ;
      GXv_char9[0] = AV128descuTipoConCod ;
      new web.gettiposconceptocod(remoteHandle, context).execute( AV37CliCod, GXv_char4, GXv_char3, GXv_char9) ;
      guardaliquidacion.this.AV126remuTipoConCod = GXv_char4[0] ;
      guardaliquidacion.this.AV127noRemuTipoConCod = GXv_char3[0] ;
      guardaliquidacion.this.AV128descuTipoConCod = GXv_char9[0] ;
      if ( (0==AV116LiqRelNro) && GXutil.dateCompare(GXutil.nullDate(), AV50LiqFecImp) )
      {
         GXv_char9[0] = AV92ParmValue ;
         new web.getparametro(remoteHandle, context).execute( AV37CliCod, new web.auto_imprimir_pdfliqleg_codigoparam(remoteHandle, context).executeUdp( ), GXv_char9) ;
         guardaliquidacion.this.AV92ParmValue = GXv_char9[0] ;
         if ( GXutil.strcmp(GXutil.trim( GXutil.upper( AV92ParmValue)), httpContext.getMessage( "NO", "")) != 0 )
         {
            AV152LiqLotePDF = (short)(1) ;
         }
         else
         {
            AV152LiqLotePDF = (short)(2) ;
         }
         new web.grabaliquidacionlote(remoteHandle, context).execute( AV37CliCod, AV9EmpCod, AV14LiqNro, AV137LiqLote, httpContext.getMessage( "PRINCIPALES", ""), (short)(1), "", AV35LegNumero, AV155daemonUUID) ;
         if ( GXutil.strcmp(AV159flujoGenRecPalabra, "3") == 0 )
         {
            if ( GXutil.strcmp(AV163liqRecibosModoPalabra, httpContext.getMessage( "DAEMON", "")) == 0 )
            {
               GXt_char2 = AV166recibosdaemonUUID ;
               GXv_char9[0] = GXt_char2 ;
               new web.daemondisponible(remoteHandle, context).execute( AV37CliCod, "GENERACION_PDFS", GXv_char9) ;
               guardaliquidacion.this.GXt_char2 = GXv_char9[0] ;
               AV166recibosdaemonUUID = GXt_char2 ;
               GXv_boolean5[0] = AV172validoEs ;
               new web.daemonvalido(remoteHandle, context).execute( AV166recibosdaemonUUID, true, GXv_boolean5) ;
               guardaliquidacion.this.AV172validoEs = GXv_boolean5[0] ;
               if ( ! AV172validoEs )
               {
                  AV166recibosdaemonUUID = httpContext.getMessage( "LOCAL (falló daemon)", "") ;
               }
            }
            else
            {
               AV166recibosdaemonUUID = httpContext.getMessage( "LOCAL O HTTP", "") ;
            }
            new web.msgdebug_prod2(remoteHandle, context).execute( AV37CliCod, AV183Pgmname, httpContext.getMessage( "llama a grabaLiquidacionLote con &LiqLotePDF ", "")+GXutil.trim( GXutil.str( AV152LiqLotePDF, 4, 0))+httpContext.getMessage( " &recibosdaemonUUID ", "")+GXutil.trim( AV166recibosdaemonUUID)) ;
            new web.grabaliquidacionlote(remoteHandle, context).execute( AV37CliCod, AV9EmpCod, AV14LiqNro, AV137LiqLote, httpContext.getMessage( "GENERACION_PDFS", ""), AV152LiqLotePDF, "", AV35LegNumero, AV166recibosdaemonUUID) ;
            if ( ( AV157desgloceEs ) && ( GXutil.strcmp(AV178LiqModTra, "E") == 0 ) )
            {
               if ( GXutil.strcmp(AV161liqDepLSDModoPalabra, httpContext.getMessage( "DAEMON", "")) == 0 )
               {
                  GXt_char2 = AV156depLSDdaemonUUID ;
                  GXv_char9[0] = GXt_char2 ;
                  new web.daemondisponible(remoteHandle, context).execute( AV37CliCod, "DEPENDENCIAS_LSD", GXv_char9) ;
                  guardaliquidacion.this.GXt_char2 = GXv_char9[0] ;
                  AV156depLSDdaemonUUID = GXt_char2 ;
                  GXv_boolean5[0] = AV172validoEs ;
                  new web.daemonvalido(remoteHandle, context).execute( AV156depLSDdaemonUUID, true, GXv_boolean5) ;
                  guardaliquidacion.this.AV172validoEs = GXv_boolean5[0] ;
                  if ( ! AV172validoEs )
                  {
                     AV156depLSDdaemonUUID = httpContext.getMessage( "LOCAL (falló daemon)", "") ;
                  }
               }
               else
               {
                  AV156depLSDdaemonUUID = httpContext.getMessage( "LOCAL O HTTP", "") ;
               }
               new web.grabaliquidacionlote(remoteHandle, context).execute( AV37CliCod, AV9EmpCod, AV14LiqNro, AV137LiqLote, httpContext.getMessage( "DEPENDENCIAS_LSD", ""), (short)(1), "", AV35LegNumero, AV156depLSDdaemonUUID) ;
            }
         }
      }
      AV110segunParOK = true ;
      if ( GXutil.dateCompare(GXutil.nullDate(), AV50LiqFecImp) )
      {
         GXv_decimal10[0] = AV140base_imp_min ;
         GXv_decimal11[0] = AV139base_imp_max ;
         GXv_char9[0] = AV138basesError ;
         new web.getbaseimpmaxymin(remoteHandle, context).execute( AV37CliCod, AV54LiqPeriodo, "Calculo", false, GXv_decimal10, GXv_decimal11, GXv_char9) ;
         guardaliquidacion.this.AV140base_imp_min = GXv_decimal10[0] ;
         guardaliquidacion.this.AV139base_imp_max = GXv_decimal11[0] ;
         guardaliquidacion.this.AV138basesError = GXv_char9[0] ;
         if ( ! (GXutil.strcmp("", AV138basesError)==0) )
         {
            AV109GeneralConceptosOK = false ;
         }
         else
         {
            GXv_int8[0] = AV141cantDiasMes ;
            new web.diasmes(remoteHandle, context).execute( AV37CliCod, AV54LiqPeriodo, GXv_int8) ;
            guardaliquidacion.this.AV141cantDiasMes = (byte)((byte)(GXv_int8[0])) ;
            AV36i = (short)(1) ;
            if ( ! AV173reLiquidacion )
            {
               while ( AV36i <= AV35LegNumero.size() )
               {
                  if ( ! (GXutil.strcmp("", AV118parmLiqLegCatCodigo)==0) )
                  {
                     AV113LiqLegCatCodigo = AV118parmLiqLegCatCodigo ;
                     AV114LiqLegConvenio = AV119parmLiqLegConvenio ;
                  }
                  else
                  {
                     GXv_char9[0] = AV113LiqLegCatCodigo ;
                     GXv_char4[0] = AV114LiqLegConvenio ;
                     new web.obtcategorialegajo(remoteHandle, context).execute( AV37CliCod, AV9EmpCod, 0, ((Number) AV35LegNumero.elementAt(-1+AV36i)).intValue(), GXv_char9, GXv_char4) ;
                     guardaliquidacion.this.AV113LiqLegCatCodigo = GXv_char9[0] ;
                     guardaliquidacion.this.AV114LiqLegConvenio = GXv_char4[0] ;
                  }
                  if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV120parmLiqLegSueldo)==0) )
                  {
                     AV115LiqLegSueldo = AV120parmLiqLegSueldo ;
                  }
                  else
                  {
                     AV130LegClase = AV177LiqFrecPag ;
                     GXv_date7[0] = AV131fecha ;
                     GXv_date12[0] = AV129finPeriodo ;
                     new web.getrangoperiodos(remoteHandle, context).execute( AV37CliCod, AV9EmpCod, AV14LiqNro, ((Number) AV35LegNumero.elementAt(-1+AV36i)).intValue(), AV24TliqCod, AV130LegClase, AV54LiqPeriodo, false, GXv_date7, GXv_date12) ;
                     guardaliquidacion.this.AV131fecha = GXv_date7[0] ;
                     guardaliquidacion.this.AV129finPeriodo = GXv_date12[0] ;
                     GXv_decimal11[0] = AV115LiqLegSueldo ;
                     GXv_char9[0] = AV143LegSuelTipo ;
                     GXv_int8[0] = (short)(0) ;
                     GXv_boolean5[0] = false ;
                     new web.getlegajosueldoultimo(remoteHandle, context).execute( AV37CliCod, AV9EmpCod, 0, ((Number) AV35LegNumero.elementAt(-1+AV36i)).intValue(), AV129finPeriodo, GXv_decimal11, GXv_char9, GXv_int8, GXv_boolean5) ;
                     guardaliquidacion.this.AV115LiqLegSueldo = GXv_decimal11[0] ;
                     guardaliquidacion.this.AV143LegSuelTipo = GXv_char9[0] ;
                  }
                  new web.newliquidacionlegajo(remoteHandle, context).execute( AV37CliCod, AV9EmpCod, AV14LiqNro, ((Number) AV35LegNumero.elementAt(-1+AV36i)).intValue(), AV54LiqPeriodo, AV24TliqCod, (byte)(1), "", AV114LiqLegConvenio, AV113LiqLegCatCodigo, AV115LiqLegSueldo) ;
                  AV36i = (short)(AV36i+1) ;
               }
            }
            Application.commitDataStores(context, remoteHandle, pr_default, "guardaliquidacion");
            GXv_boolean5[0] = AV122EmpLiqGan ;
            new web.getempresaliquidaganancias(remoteHandle, context).execute( AV37CliCod, AV9EmpCod, GXv_boolean5) ;
            guardaliquidacion.this.AV122EmpLiqGan = GXv_boolean5[0] ;
            if ( AV122EmpLiqGan )
            {
               GXv_char9[0] = AV121retroGananciasError ;
               new web.actualizarretroactivosganancias(remoteHandle, context).execute( AV37CliCod, AV9EmpCod, AV14LiqNro, AV35LegNumero, AV48LiqPerAno, AV54LiqPeriodo, GXv_char9) ;
               guardaliquidacion.this.AV121retroGananciasError = GXv_char9[0] ;
            }
            GXt_char2 = AV92ParmValue ;
            GXv_char9[0] = GXt_char2 ;
            new web.getparametro(remoteHandle, context).execute( AV37CliCod, httpContext.getMessage( "forzar_proc4", ""), GXv_char9) ;
            guardaliquidacion.this.GXt_char2 = GXv_char9[0] ;
            AV92ParmValue = GXt_char2 ;
            AV108forzarProc4 = GXutil.boolval( AV92ParmValue) ;
            if ( (GXutil.strcmp("", AV121retroGananciasError)==0) )
            {
               GXt_dtime13 = AV41ahora ;
               GXv_dtime14[0] = GXt_dtime13 ;
               new web.getahora(remoteHandle, context).execute( AV37CliCod, GXv_dtime14) ;
               guardaliquidacion.this.GXt_dtime13 = GXv_dtime14[0] ;
               AV41ahora = GXt_dtime13 ;
               GXv_char9[0] = AV53TliqDesc ;
               new web.gettipoliqdesc(remoteHandle, context).execute( AV37CliCod, AV24TliqCod, GXv_char9) ;
               guardaliquidacion.this.AV53TliqDesc = GXv_char9[0] ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV37CliCod, AV183Pgmname, httpContext.getMessage( "legcount ", "")+GXutil.trim( GXutil.str( AV35LegNumero.size(), 9, 0))) ;
               AV36i = (short)(1) ;
               while ( AV36i <= AV35LegNumero.size() )
               {
                  AV154auxLegNumero = ((Number) AV35LegNumero.elementAt(-1+AV36i)).intValue() ;
                  /* Execute user subroutine: 'LEGAJO PROCESAR CONCEPTOS PRINCIPALES' */
                  S121 ();
                  if ( returnInSub )
                  {
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
                  if ( AV158exit )
                  {
                     if (true) break;
                  }
                  if ( GXutil.strcmp(AV159flujoGenRecPalabra, "3") == 0 )
                  {
                     GXv_char9[0] = AV165reciboError ;
                     new web.ejecutarrecibo(remoteHandle, context).execute( AV37CliCod, AV9EmpCod, AV14LiqNro, AV164nadaLegNumero, AV154auxLegNumero, AV137LiqLote, AV123clientId, "", AV163liqRecibosModoPalabra, AV168sqsGenPdfsURL, httpContext.getMessage( "GenRecibos", ""), "", AV169vacioCollNum, GXutil.trim( GXutil.booltostr( AV157desgloceEs)), AV159flujoGenRecPalabra, (short)(-1), AV166recibosdaemonUUID, false, GXv_char9) ;
                     guardaliquidacion.this.AV165reciboError = GXv_char9[0] ;
                     if ( ! (GXutil.strcmp("", AV165reciboError)==0) )
                     {
                        AV82conceptosOK = false ;
                        AV109GeneralConceptosOK = false ;
                        new web.setliqlegerror(remoteHandle, context).execute( AV37CliCod, AV9EmpCod, AV14LiqNro, AV154auxLegNumero, AV165reciboError) ;
                        AV142auxError = AV165reciboError ;
                        /* Execute user subroutine: 'ADD TODOS LEG ERROR' */
                        S111 ();
                        if ( returnInSub )
                        {
                           returnInSub = true;
                           cleanup();
                           if (true) return;
                        }
                        if (true) break;
                     }
                     if ( ( AV157desgloceEs ) && ( GXutil.strcmp(AV178LiqModTra, "E") == 0 ) )
                     {
                        GXv_char9[0] = httpContext.getMessage( "error", "") ;
                        new web.ejecutardeplsd(remoteHandle, context).execute( AV37CliCod, AV9EmpCod, AV14LiqNro, AV164nadaLegNumero, AV154auxLegNumero, AV137LiqLote, AV123clientId, "DEPENDENCIAS_LSD", AV161liqDepLSDModoPalabra, AV174sqsDepLSDURL, httpContext.getMessage( "CalcDepLSD", ""), "", AV169vacioCollNum, GXutil.trim( GXutil.booltostr( AV157desgloceEs)), AV159flujoGenRecPalabra, (short)(-1), AV156depLSDdaemonUUID, false, GXv_char9) ;
                     }
                  }
                  AV36i = (short)(AV36i+1) ;
               }
               new web.msgdebug_prod2(remoteHandle, context).execute( AV37CliCod, AV183Pgmname, httpContext.getMessage( "ahora 6", "")) ;
            }
         }
         new web.msgdebug_prod2(remoteHandle, context).execute( AV37CliCod, AV183Pgmname, httpContext.getMessage( "ahora 7", "")) ;
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV37CliCod, AV183Pgmname, httpContext.getMessage( "ahora 8 &GeneralConceptosOK ", "")+GXutil.trim( GXutil.booltostr( AV109GeneralConceptosOK))) ;
      if ( ( AV109GeneralConceptosOK ) && ! AV110segunParOK )
      {
         AV109GeneralConceptosOK = false ;
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV37CliCod, AV183Pgmname, httpContext.getMessage( "&GeneralConceptosOK ", "")+GXutil.trim( GXutil.booltostr( AV109GeneralConceptosOK))+httpContext.getMessage( " &segunParOK ", "")+GXutil.trim( GXutil.booltostr( AV110segunParOK))) ;
      GXv_boolean5[0] = AV111errorHay ;
      GXv_boolean15[0] = AV135sinProcesarHay ;
      GXv_char9[0] = AV83errorTexto ;
      new web.manejarerrorliquidacion(remoteHandle, context).execute( AV37CliCod, AV9EmpCod, AV14LiqNro, AV116LiqRelNro, AV50LiqFecImp, AV121retroGananciasError, AV77errorCiclicoHay, AV109GeneralConceptosOK, AV138basesError, AV123clientId, AV137LiqLote, AV147todosLegError, GXv_boolean5, GXv_boolean15, GXv_char9) ;
      guardaliquidacion.this.AV111errorHay = GXv_boolean5[0] ;
      guardaliquidacion.this.AV135sinProcesarHay = GXv_boolean15[0] ;
      guardaliquidacion.this.AV83errorTexto = GXv_char9[0] ;
      if ( GXutil.dateCompare(GXutil.nullDate(), AV50LiqFecImp) )
      {
         if ( ! (GXutil.strcmp("", AV83errorTexto)==0) )
         {
            AV83errorTexto += " (" + GXutil.trim( AV183Pgmname) + ")" ;
         }
         new web.grabaliquidacionlote(remoteHandle, context).execute( AV37CliCod, AV9EmpCod, AV14LiqNro, AV137LiqLote, httpContext.getMessage( "PRINCIPALES", ""), (short)(2), AV83errorTexto, AV35LegNumero, "") ;
      }
      GXv_int16[0] = AV65auxLiqEstado ;
      new web.getliqestado(remoteHandle, context).execute( AV37CliCod, AV9EmpCod, AV14LiqNro, GXv_int16) ;
      guardaliquidacion.this.AV65auxLiqEstado = GXv_int16[0] ;
      if ( AV65auxLiqEstado == 2 )
      {
         AV39erroresLiq = httpContext.getMessage( "ERROR", "") ;
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV37CliCod, AV183Pgmname, httpContext.getMessage( "&erroresLiq ", "")+GXutil.trim( AV39erroresLiq)+httpContext.getMessage( " &retroGananciasError ", "")+GXutil.trim( AV121retroGananciasError)+httpContext.getMessage( " &LiqNro ", "")+GXutil.trim( GXutil.str( AV14LiqNro, 8, 0))+httpContext.getMessage( " &errorHay ", "")+GXutil.trim( GXutil.booltostr( AV111errorHay))) ;
      if ( (GXutil.strcmp("", AV39erroresLiq)==0) && (GXutil.strcmp("", AV121retroGananciasError)==0) && ! AV111errorHay )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV37CliCod, AV183Pgmname, httpContext.getMessage( "&LiqFecImp ", "")+GXutil.trim( localUtil.ttoc( AV50LiqFecImp, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "))) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV37CliCod, AV183Pgmname, httpContext.getMessage( "no tiene errorres &LiqRelNro ", "")+GXutil.trim( GXutil.str( AV116LiqRelNro, 8, 0))) ;
         if ( GXutil.dateCompare(GXutil.nullDate(), AV50LiqFecImp) && (0==AV116LiqRelNro) )
         {
            if ( AV100segundoPlano )
            {
               new web.msgdebug_prod2(remoteHandle, context).execute( AV37CliCod, AV183Pgmname, httpContext.getMessage( "manda a procesosSegundoPlano &ClientId ", "")+GXutil.trim( AV123clientId)) ;
               Application.commitDataStores(context, remoteHandle, pr_default, "guardaliquidacion");
               new web.msgdebug_prod2(remoteHandle, context).execute( AV37CliCod, AV183Pgmname, httpContext.getMessage( "vuelve de pdfs", "")) ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV37CliCod, AV183Pgmname, httpContext.getMessage( "vuelve de procesosSecundarios", "")) ;
            }
            else
            {
               new web.setliqestadossecundarios(remoteHandle, context).execute( AV37CliCod, AV9EmpCod, AV14LiqNro, (byte)(3), "Completo") ;
            }
         }
         else
         {
            if ( ! (0==AV116LiqRelNro) )
            {
               new web.setliqestadossecundarios(remoteHandle, context).execute( AV37CliCod, AV9EmpCod, AV14LiqNro, (byte)(3), "Completo") ;
            }
         }
         new web.msgdebug_prod2(remoteHandle, context).execute( AV37CliCod, AV183Pgmname, httpContext.getMessage( "commit postgres", "")) ;
         if ( ! AV135sinProcesarHay )
         {
            Application.commitDataStores(context, remoteHandle, pr_default, "guardaliquidacion");
         }
      }
      else
      {
         AV111errorHay = true ;
         if ( ! (GXutil.strcmp("", AV121retroGananciasError)==0) )
         {
            AV142auxError = AV121retroGananciasError ;
         }
         else
         {
            if ( ! (GXutil.strcmp("", AV138basesError)==0) )
            {
               AV142auxError = AV138basesError ;
            }
            else
            {
               if ( ! (GXutil.strcmp("", AV147todosLegError)==0) )
               {
                  AV142auxError = GXutil.trim( AV147todosLegError) ;
               }
               else
               {
                  GXt_char2 = AV142auxError ;
                  GXv_char9[0] = GXt_char2 ;
                  new web.textoerrorgeneralliq(remoteHandle, context).execute( AV37CliCod, GXv_char9) ;
                  guardaliquidacion.this.GXt_char2 = GXv_char9[0] ;
                  AV142auxError = GXt_char2 ;
               }
            }
         }
         if ( ! (GXutil.strcmp("", AV142auxError)==0) )
         {
            AV142auxError += " (" + GXutil.trim( AV183Pgmname) + ")" ;
         }
         new web.grabaliquidacionlote(remoteHandle, context).execute( AV37CliCod, AV9EmpCod, AV14LiqNro, AV137LiqLote, httpContext.getMessage( "PRINCIPALES", ""), (short)(2), AV142auxError, AV35LegNumero, "") ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'ADD TODOS LEG ERROR' Routine */
      returnInSub = false ;
      if ( GXutil.strSearch( AV147todosLegError, GXutil.trim( AV142auxError), 1) == 0 )
      {
         if ( ! (GXutil.strcmp("", AV147todosLegError)==0) )
         {
            AV147todosLegError += ". " ;
         }
         AV147todosLegError += AV142auxError ;
      }
   }

   public void S121( )
   {
      /* 'LEGAJO PROCESAR CONCEPTOS PRINCIPALES' Routine */
      returnInSub = false ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV37CliCod, AV183Pgmname, httpContext.getMessage( "!ahora 01", "")) ;
      GXv_char9[0] = AV95ConveCodigo ;
      new web.empleadogetconvenio(remoteHandle, context).execute( AV37CliCod, AV9EmpCod, AV154auxLegNumero, GXv_char9) ;
      guardaliquidacion.this.AV95ConveCodigo = GXv_char9[0] ;
      GXv_char9[0] = AV74appendLiqLog ;
      GXv_int17[0] = AV80LiqDSecuencial ;
      GXv_boolean15[0] = AV82conceptosOK ;
      GXv_objcol_char18[0] = AV107dummyCondicionLiquidacion ;
      GXv_objcol_char19[0] = AV106dummyConCodigo ;
      GXv_int16[0] = AV144liq_nivel_complejidad ;
      GXv_boolean5[0] = AV124redondeoHay ;
      new web.genconcepporlegajo7(remoteHandle, context).execute( AV37CliCod, AV9EmpCod, AV14LiqNro, AV24TliqCod, AV154auxLegNumero, AV54LiqPeriodo, 0, false, AV95ConveCodigo, httpContext.getMessage( "LIQUIDACION", ""), AV116LiqRelNro, AV133LiqSac, GXv_char9, GXv_int17, GXv_boolean15, GXv_objcol_char18, GXv_objcol_char19, GXv_int16, GXv_boolean5) ;
      guardaliquidacion.this.AV74appendLiqLog = GXv_char9[0] ;
      guardaliquidacion.this.AV80LiqDSecuencial = GXv_int17[0] ;
      guardaliquidacion.this.AV82conceptosOK = GXv_boolean15[0] ;
      AV107dummyCondicionLiquidacion = GXv_objcol_char18[0] ;
      AV106dummyConCodigo = GXv_objcol_char19[0] ;
      guardaliquidacion.this.AV144liq_nivel_complejidad = GXv_int16[0] ;
      guardaliquidacion.this.AV124redondeoHay = GXv_boolean5[0] ;
      Application.commitDataStores(context, remoteHandle, pr_default, "guardaliquidacion");
      new web.msgdebug_prod2(remoteHandle, context).execute( AV37CliCod, AV183Pgmname, httpContext.getMessage( "&conceptosOK ", "")+GXutil.trim( GXutil.booltostr( AV82conceptosOK))) ;
      if ( ! AV82conceptosOK )
      {
         AV109GeneralConceptosOK = false ;
         AV158exit = true ;
      }
      else
      {
         if ( GXutil.dateCompare(GXutil.nullDate(), AV50LiqFecImp) )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV37CliCod, AV183Pgmname, httpContext.getMessage( " LegNumero ", "")+GXutil.trim( GXutil.str( AV154auxLegNumero, 8, 0))+httpContext.getMessage( " conceptosok ", "")+GXutil.trim( GXutil.booltostr( AV82conceptosOK))) ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV37CliCod, AV183Pgmname, httpContext.getMessage( "&liq_nivel_complejidad ", "")+GXutil.trim( GXutil.str( AV144liq_nivel_complejidad, 1, 0))) ;
            AV58retroError = "" ;
            if ( AV144liq_nivel_complejidad != 1 )
            {
               GXv_char9[0] = AV58retroError ;
               new web.procliquidacionretroactivo(remoteHandle, context).execute( AV37CliCod, AV9EmpCod, AV14LiqNro, AV154auxLegNumero, AV155daemonUUID, GXv_char9) ;
               guardaliquidacion.this.AV58retroError = GXv_char9[0] ;
            }
            new web.msgdebug_prod2(remoteHandle, context).execute( AV37CliCod, AV183Pgmname, httpContext.getMessage( "&retroError ", "")+GXutil.trim( AV58retroError)) ;
            if ( ! (GXutil.strcmp("", AV58retroError)==0) )
            {
               AV82conceptosOK = false ;
               AV109GeneralConceptosOK = false ;
               AV142auxError = httpContext.getMessage( "No se ha podido generar la liquidación retroactiva para concepto con fórmula que hace referencia a cálculo retroactivo. ", "") + GXutil.trim( AV58retroError) ;
               new web.setliqlegerror(remoteHandle, context).execute( AV37CliCod, AV9EmpCod, AV14LiqNro, AV154auxLegNumero, AV142auxError) ;
               /* Execute user subroutine: 'ADD TODOS LEG ERROR' */
               S111 ();
               if (returnInSub) return;
            }
            else
            {
               new web.msgdebug_prod2(remoteHandle, context).execute( AV37CliCod, AV183Pgmname, "?") ;
               GXv_int16[0] = AV151actualLiqEstado ;
               new web.getliqestado(remoteHandle, context).execute( AV37CliCod, AV9EmpCod, AV14LiqNro, GXv_int16) ;
               guardaliquidacion.this.AV151actualLiqEstado = GXv_int16[0] ;
               if ( AV151actualLiqEstado != 1 )
               {
                  new web.setliqestado(remoteHandle, context).execute( AV37CliCod, AV9EmpCod, AV14LiqNro, (byte)(1)) ;
               }
               if ( AV144liq_nivel_complejidad == 1 )
               {
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV37CliCod, AV183Pgmname, httpContext.getMessage( "todo bien es basica", "")) ;
                  AV77errorCiclicoHay = false ;
                  AV102errorComunHay = false ;
               }
               else
               {
                  GXv_boolean15[0] = AV77errorCiclicoHay ;
                  GXv_boolean5[0] = AV102errorComunHay ;
                  GXv_char9[0] = AV145principalError ;
                  new web.procliquidacion(remoteHandle, context).execute( AV37CliCod, AV9EmpCod, AV154auxLegNumero, AV54LiqPeriodo, AV24TliqCod, AV14LiqNro, AV116LiqRelNro, AV144liq_nivel_complejidad, AV124redondeoHay, AV126remuTipoConCod, AV127noRemuTipoConCod, AV128descuTipoConCod, AV140base_imp_min, AV139base_imp_max, AV141cantDiasMes, AV183Pgmname, AV95ConveCodigo, GXv_boolean15, GXv_boolean5, GXv_char9) ;
                  guardaliquidacion.this.AV77errorCiclicoHay = GXv_boolean15[0] ;
                  guardaliquidacion.this.AV102errorComunHay = GXv_boolean5[0] ;
                  guardaliquidacion.this.AV145principalError = GXv_char9[0] ;
                  Application.commitDataStores(context, remoteHandle, pr_default, "guardaliquidacion");
               }
               new web.msgdebug_prod2(remoteHandle, context).execute( AV37CliCod, AV183Pgmname, httpContext.getMessage( "&errorComunHay ", "")+GXutil.trim( GXutil.booltostr( AV102errorComunHay))+httpContext.getMessage( " &principalError ", "")+AV145principalError) ;
               if ( AV102errorComunHay )
               {
                  AV82conceptosOK = false ;
                  AV109GeneralConceptosOK = false ;
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV37CliCod, AV183Pgmname, httpContext.getMessage( "&conceptosOK = false", "")) ;
                  if ( ! (GXutil.strcmp("", AV145principalError)==0) )
                  {
                     AV146error = GXutil.trim( AV145principalError) ;
                  }
                  else
                  {
                     GXt_char2 = AV146error ;
                     GXv_char9[0] = GXt_char2 ;
                     new web.textoerrorgeneralliq(remoteHandle, context).execute( AV37CliCod, GXv_char9) ;
                     guardaliquidacion.this.GXt_char2 = GXv_char9[0] ;
                     AV146error = GXt_char2 ;
                  }
                  new web.setliqlegerror(remoteHandle, context).execute( AV37CliCod, AV9EmpCod, AV14LiqNro, AV154auxLegNumero, AV146error) ;
                  AV142auxError = AV146error ;
                  /* Execute user subroutine: 'ADD TODOS LEG ERROR' */
                  S111 ();
                  if (returnInSub) return;
               }
               if ( AV77errorCiclicoHay )
               {
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV37CliCod, AV183Pgmname, httpContext.getMessage( "chau", "")) ;
                  new web.setliqlegerror(remoteHandle, context).execute( AV37CliCod, AV9EmpCod, AV14LiqNro, AV154auxLegNumero, new web.textoerrorciclico(remoteHandle, context).executeUdp( AV37CliCod)) ;
                  GXt_char2 = AV142auxError ;
                  GXv_char9[0] = GXt_char2 ;
                  new web.textoerrorciclico(remoteHandle, context).execute( AV37CliCod, GXv_char9) ;
                  guardaliquidacion.this.GXt_char2 = GXv_char9[0] ;
                  AV142auxError = GXt_char2 ;
                  /* Execute user subroutine: 'ADD TODOS LEG ERROR' */
                  S111 ();
                  if (returnInSub) return;
                  AV158exit = true ;
               }
               if ( ! AV77errorCiclicoHay && ! AV102errorComunHay )
               {
                  new web.setlegrecalcularliq(remoteHandle, context).execute( AV37CliCod, AV9EmpCod, AV154auxLegNumero, false) ;
               }
            }
         }
      }
   }

   protected void cleanup( )
   {
      this.aP35[0] = guardaliquidacion.this.AV111errorHay;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV183Pgmname = "" ;
      AV163liqRecibosModoPalabra = "" ;
      AV161liqDepLSDModoPalabra = "" ;
      AV137LiqLote = "" ;
      AV92ParmValue = "" ;
      AV167RestLocRNro = new GXSimpleCollection<Short>(Short.class, "internal", "");
      GXv_objcol_int6 = new GXSimpleCollection[1] ;
      AV168sqsGenPdfsURL = "" ;
      AV174sqsDepLSDURL = "" ;
      AV159flujoGenRecPalabra = "" ;
      AV54LiqPeriodo = GXutil.nullDate() ;
      GXt_char1 = "" ;
      AV126remuTipoConCod = "" ;
      AV127noRemuTipoConCod = "" ;
      GXv_char3 = new String[1] ;
      AV128descuTipoConCod = "" ;
      AV166recibosdaemonUUID = "" ;
      AV156depLSDdaemonUUID = "" ;
      AV140base_imp_min = DecimalUtil.ZERO ;
      GXv_decimal10 = new java.math.BigDecimal[1] ;
      AV139base_imp_max = DecimalUtil.ZERO ;
      AV138basesError = "" ;
      AV113LiqLegCatCodigo = "" ;
      AV114LiqLegConvenio = "" ;
      GXv_char4 = new String[1] ;
      AV115LiqLegSueldo = DecimalUtil.ZERO ;
      AV131fecha = GXutil.nullDate() ;
      GXv_date7 = new java.util.Date[1] ;
      AV129finPeriodo = GXutil.nullDate() ;
      GXv_date12 = new java.util.Date[1] ;
      GXv_decimal11 = new java.math.BigDecimal[1] ;
      AV143LegSuelTipo = "" ;
      GXv_int8 = new short[1] ;
      AV121retroGananciasError = "" ;
      AV41ahora = GXutil.resetTime( GXutil.nullDate() );
      GXt_dtime13 = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime14 = new java.util.Date[1] ;
      AV53TliqDesc = "" ;
      AV164nadaLegNumero = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      AV169vacioCollNum = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV165reciboError = "" ;
      AV142auxError = "" ;
      AV147todosLegError = "" ;
      AV83errorTexto = "" ;
      AV39erroresLiq = "" ;
      AV95ConveCodigo = "" ;
      AV74appendLiqLog = "" ;
      GXv_int17 = new int[1] ;
      AV107dummyCondicionLiquidacion = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_char18 = new GXSimpleCollection[1] ;
      AV106dummyConCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_char19 = new GXSimpleCollection[1] ;
      AV58retroError = "" ;
      GXv_int16 = new byte[1] ;
      GXv_boolean15 = new boolean[1] ;
      GXv_boolean5 = new boolean[1] ;
      AV145principalError = "" ;
      AV146error = "" ;
      GXt_char2 = "" ;
      GXv_char9 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.guardaliquidacion__default(),
         new Object[] {
         }
      );
      AV183Pgmname = "GuardaLiquidacion" ;
      /* GeneXus formulas. */
      AV183Pgmname = "GuardaLiquidacion" ;
      Gx_err = (short)(0) ;
   }

   private byte AV10LiqClase ;
   private byte AV177LiqFrecPag ;
   private byte AV12LiqEstado ;
   private byte AV46LiqDepPerMes ;
   private byte AV47LiqPerMes ;
   private byte AV141cantDiasMes ;
   private byte AV130LegClase ;
   private byte AV65auxLiqEstado ;
   private byte AV144liq_nivel_complejidad ;
   private byte AV151actualLiqEstado ;
   private byte GXv_int16[] ;
   private short AV9EmpCod ;
   private short AV45LiqDepPerAno ;
   private short AV48LiqPerAno ;
   private short AV125PaiCod ;
   private short AV152LiqLotePDF ;
   private short AV36i ;
   private short GXv_int8[] ;
   private short Gx_err ;
   private int AV37CliCod ;
   private int AV14LiqNro ;
   private int AV116LiqRelNro ;
   private int AV154auxLegNumero ;
   private int AV80LiqDSecuencial ;
   private int GXv_int17[] ;
   private java.math.BigDecimal AV120parmLiqLegSueldo ;
   private java.math.BigDecimal AV140base_imp_min ;
   private java.math.BigDecimal GXv_decimal10[] ;
   private java.math.BigDecimal AV139base_imp_max ;
   private java.math.BigDecimal AV115LiqLegSueldo ;
   private java.math.BigDecimal GXv_decimal11[] ;
   private String AV178LiqModTra ;
   private String AV180LiqTipoTarifa ;
   private String AV24TliqCod ;
   private String AV34AplicaA ;
   private String AV43LiqDepBanCod ;
   private String AV96parmLiqPerPalabra ;
   private String AV119parmLiqLegConvenio ;
   private String AV118parmLiqLegCatCodigo ;
   private String AV155daemonUUID ;
   private String AV183Pgmname ;
   private String AV163liqRecibosModoPalabra ;
   private String AV161liqDepLSDModoPalabra ;
   private String AV159flujoGenRecPalabra ;
   private String GXt_char1 ;
   private String AV126remuTipoConCod ;
   private String AV127noRemuTipoConCod ;
   private String GXv_char3[] ;
   private String AV128descuTipoConCod ;
   private String AV166recibosdaemonUUID ;
   private String AV156depLSDdaemonUUID ;
   private String AV113LiqLegCatCodigo ;
   private String AV114LiqLegConvenio ;
   private String GXv_char4[] ;
   private String AV143LegSuelTipo ;
   private String AV95ConveCodigo ;
   private String GXt_char2 ;
   private String GXv_char9[] ;
   private java.util.Date AV50LiqFecImp ;
   private java.util.Date AV41ahora ;
   private java.util.Date GXt_dtime13 ;
   private java.util.Date GXv_dtime14[] ;
   private java.util.Date AV13LiqFecha ;
   private java.util.Date AV42LiqFecPago ;
   private java.util.Date AV176LiqPerDes ;
   private java.util.Date AV175LiqPerHas ;
   private java.util.Date AV44LiqDepPrvFec ;
   private java.util.Date AV54LiqPeriodo ;
   private java.util.Date AV131fecha ;
   private java.util.Date GXv_date7[] ;
   private java.util.Date AV129finPeriodo ;
   private java.util.Date GXv_date12[] ;
   private boolean AV33final ;
   private boolean AV133LiqSac ;
   private boolean AV173reLiquidacion ;
   private boolean AV111errorHay ;
   private boolean AV157desgloceEs ;
   private boolean AV160GenRec_RestLocHab ;
   private boolean AV100segundoPlano ;
   private boolean AV109GeneralConceptosOK ;
   private boolean AV172validoEs ;
   private boolean AV110segunParOK ;
   private boolean AV122EmpLiqGan ;
   private boolean AV108forzarProc4 ;
   private boolean returnInSub ;
   private boolean AV158exit ;
   private boolean AV82conceptosOK ;
   private boolean AV77errorCiclicoHay ;
   private boolean AV135sinProcesarHay ;
   private boolean AV124redondeoHay ;
   private boolean AV102errorComunHay ;
   private boolean GXv_boolean15[] ;
   private boolean GXv_boolean5[] ;
   private String AV92ParmValue ;
   private String AV74appendLiqLog ;
   private String AV11LiqDescrip ;
   private String AV60LiqNombre ;
   private String AV123clientId ;
   private String AV132LiqSacLog ;
   private String AV137LiqLote ;
   private String AV168sqsGenPdfsURL ;
   private String AV174sqsDepLSDURL ;
   private String AV138basesError ;
   private String AV121retroGananciasError ;
   private String AV53TliqDesc ;
   private String AV165reciboError ;
   private String AV142auxError ;
   private String AV147todosLegError ;
   private String AV83errorTexto ;
   private String AV39erroresLiq ;
   private String AV58retroError ;
   private String AV145principalError ;
   private String AV146error ;
   private GXSimpleCollection<Short> AV167RestLocRNro ;
   private GXSimpleCollection<Short> GXv_objcol_int6[] ;
   private GXSimpleCollection<Short> AV169vacioCollNum ;
   private GXSimpleCollection<Integer> AV35LegNumero ;
   private GXSimpleCollection<Integer> AV164nadaLegNumero ;
   private boolean[] aP35 ;
   private IDataStoreProvider pr_default ;
   private GXSimpleCollection<String> AV107dummyCondicionLiquidacion ;
   private GXSimpleCollection<String> GXv_objcol_char18[] ;
   private GXSimpleCollection<String> AV106dummyConCodigo ;
   private GXSimpleCollection<String> GXv_objcol_char19[] ;
}

final  class guardaliquidacion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
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
      }
   }

}

