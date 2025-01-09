package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class liquidacionporlotes extends GXProcedure
{
   public liquidacionporlotes( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liquidacionporlotes.class ), "" );
   }

   public liquidacionporlotes( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        GXSimpleCollection<Integer> aP3 ,
                        byte aP4 ,
                        String aP5 ,
                        byte aP6 ,
                        String aP7 ,
                        java.util.Date aP8 ,
                        java.util.Date aP9 ,
                        String aP10 ,
                        byte aP11 ,
                        short aP12 ,
                        String aP13 ,
                        boolean aP14 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             GXSimpleCollection<Integer> aP3 ,
                             byte aP4 ,
                             String aP5 ,
                             byte aP6 ,
                             String aP7 ,
                             java.util.Date aP8 ,
                             java.util.Date aP9 ,
                             String aP10 ,
                             byte aP11 ,
                             short aP12 ,
                             String aP13 ,
                             boolean aP14 )
   {
      liquidacionporlotes.this.AV11CliCod = aP0;
      liquidacionporlotes.this.AV15EmpCod = aP1;
      liquidacionporlotes.this.AV34LiqNro = aP2;
      liquidacionporlotes.this.AV21LegNumero = aP3;
      liquidacionporlotes.this.AV23LiqClase = aP4;
      liquidacionporlotes.this.AV78LiqModTra = aP5;
      liquidacionporlotes.this.AV77LiqFrecPag = aP6;
      liquidacionporlotes.this.AV79LiqTipoTarifa = aP7;
      liquidacionporlotes.this.AV76LiqPerDes = aP8;
      liquidacionporlotes.this.AV75LiqPerHas = aP9;
      liquidacionporlotes.this.AV42TliqCod = aP10;
      liquidacionporlotes.this.AV37LiqPerMes = aP11;
      liquidacionporlotes.this.AV35LiqPerAno = aP12;
      liquidacionporlotes.this.AV12clientId = aP13;
      liquidacionporlotes.this.AV74reliquidaEs = aP14;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV65liqModoPalabra ;
      GXt_char2 = AV65liqModoPalabra ;
      GXv_char3[0] = GXt_char2 ;
      new web.liq_modo2_codigoparam(remoteHandle, context).execute( "liq_modo_prin", GXv_char3) ;
      liquidacionporlotes.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV11CliCod, GXt_char2, GXv_char4) ;
      liquidacionporlotes.this.GXt_char1 = GXv_char4[0] ;
      AV65liqModoPalabra = GXt_char1 ;
      if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV65liqModoPalabra)), httpContext.getMessage( "LAMBDA", "")) == 0 )
      {
         GXv_char4[0] = AV62QueueUrl ;
         new web.getparametro(remoteHandle, context).execute( AV11CliCod, new web.url_sqs_calcliqtodo_codigoparam(remoteHandle, context).executeUdp( ), GXv_char4) ;
         liquidacionporlotes.this.AV62QueueUrl = GXv_char4[0] ;
      }
      GXv_char4[0] = AV48ParmValue ;
      new web.getparametro(remoteHandle, context).execute( AV11CliCod, new web.cantreplicasprocesos_codigoparam(remoteHandle, context).executeUdp( ), GXv_char4) ;
      liquidacionporlotes.this.AV48ParmValue = GXv_char4[0] ;
      AV60limiteReplicas = (short)(GXutil.lval( AV48ParmValue)) ;
      if ( (0==AV60limiteReplicas) )
      {
         AV60limiteReplicas = (short)(1) ;
      }
      GXv_char4[0] = AV48ParmValue ;
      new web.getparametro(remoteHandle, context).execute( AV11CliCod, new web.cantlegporloteliq_codigoparam(remoteHandle, context).executeUdp( ), GXv_char4) ;
      liquidacionporlotes.this.AV48ParmValue = GXv_char4[0] ;
      AV10cantidadPorLote = (short)(GXutil.lval( AV48ParmValue)) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV82Pgmname, httpContext.getMessage( "parm &cantidadPorLote ", "")+GXutil.trim( GXutil.str( AV10cantidadPorLote, 4, 0))) ;
      if ( ( AV10cantidadPorLote > AV21LegNumero.size() ) || (0==AV10cantidadPorLote) )
      {
         AV10cantidadPorLote = (short)(AV21LegNumero.size()) ;
      }
      AV72aux = DecimalUtil.doubleToDec(AV21LegNumero.size()/ (double) (AV10cantidadPorLote)) ;
      AV71trunc = (int)(DecimalUtil.decToDouble(GXutil.truncDecimal( AV72aux, 0))) ;
      AV68parteDecimal = AV72aux.subtract(DecimalUtil.doubleToDec(AV71trunc)) ;
      if ( AV68parteDecimal.doubleValue() > 0 )
      {
         AV58cantidadLotesPorLiq = (short)(AV71trunc+1) ;
      }
      else
      {
         AV58cantidadLotesPorLiq = (short)(AV71trunc) ;
      }
      GXv_char4[0] = AV48ParmValue ;
      new web.getparametro(remoteHandle, context).execute( AV11CliCod, new web.cantloteporliq_codigoparam(remoteHandle, context).executeUdp( ), GXv_char4) ;
      liquidacionporlotes.this.AV48ParmValue = GXv_char4[0] ;
      AV70cantidadLotesMaxPorLiq = (short)(GXutil.lval( AV48ParmValue)) ;
      if ( ( AV58cantidadLotesPorLiq > AV70cantidadLotesMaxPorLiq ) && ( AV70cantidadLotesMaxPorLiq > 0 ) )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV82Pgmname, httpContext.getMessage( "corrige", "")) ;
         AV58cantidadLotesPorLiq = AV70cantidadLotesMaxPorLiq ;
         if ( AV21LegNumero.size() < AV58cantidadLotesPorLiq )
         {
            AV58cantidadLotesPorLiq = (short)(AV21LegNumero.size()) ;
         }
         AV66auxCantidadPorLote = DecimalUtil.doubleToDec(AV21LegNumero.size()/ (double) (AV58cantidadLotesPorLiq)) ;
         AV67truncCantidadPorLote = (int)(DecimalUtil.decToDouble(GXutil.truncDecimal( AV66auxCantidadPorLote, 0))) ;
         AV68parteDecimal = AV66auxCantidadPorLote.subtract(DecimalUtil.doubleToDec(AV67truncCantidadPorLote)) ;
         if ( AV68parteDecimal.doubleValue() > 0 )
         {
            AV10cantidadPorLote = (short)(AV67truncCantidadPorLote+1) ;
         }
         else
         {
            AV10cantidadPorLote = (short)(AV67truncCantidadPorLote) ;
         }
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV82Pgmname, httpContext.getMessage( "&cantidadPorLote ", "")+GXutil.trim( GXutil.str( AV10cantidadPorLote, 4, 0))+httpContext.getMessage( " &auxCantidadPorLote ", "")+GXutil.trim( GXutil.str( AV66auxCantidadPorLote, 7, 1))+httpContext.getMessage( " &truncCantidadPorLote ", "")+GXutil.trim( GXutil.str( AV67truncCantidadPorLote, 6, 0))+httpContext.getMessage( " &parteDecimal ", "")+GXutil.trim( GXutil.str( AV68parteDecimal, 3, 1))) ;
      AV21LegNumero.sort("");
      AV18i = (short)(1) ;
      while ( AV18i <= AV21LegNumero.size() )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV82Pgmname, httpContext.getMessage( "&LegNumero ", "")+AV21LegNumero.toJSonString(false)) ;
         AV9auxLegNumero.clear();
         AV20i2 = AV18i ;
         AV17hasta = (short)(AV18i+AV10cantidadPorLote-1) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV82Pgmname, httpContext.getMessage( "i2 ", "")+GXutil.trim( GXutil.str( AV20i2, 4, 0))+httpContext.getMessage( " hjasta ", "")+GXutil.trim( GXutil.str( AV17hasta, 4, 0))) ;
         while ( AV20i2 <= AV17hasta )
         {
            if ( AV20i2 <= AV21LegNumero.size() )
            {
               AV9auxLegNumero.add((int)(((Number) AV21LegNumero.elementAt(-1+AV20i2)).intValue()), 0);
            }
            else
            {
               if (true) break;
            }
            AV20i2 = (short)(AV20i2+1) ;
         }
         new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV82Pgmname, httpContext.getMessage( " legs ", "")+GXutil.trim( AV9auxLegNumero.toJSonString(false))+httpContext.getMessage( " &CliCod ", "")+GXutil.trim( GXutil.str( AV11CliCod, 6, 0))) ;
         AV57sdt_datos_liq = (web.Sdtsdt_datos_liq)new web.Sdtsdt_datos_liq(remoteHandle, context);
         GXt_dtime5 = GXutil.resetTime( AV14dummDate );
         GXv_Sdtsdt_datos_liq6[0] = AV57sdt_datos_liq;
         new web.armarsdtdatosliqdesdeparm(remoteHandle, context).execute( AV11CliCod, AV15EmpCod, AV34LiqNro, AV28LiqFecha, AV29LiqFecPago, AV26LiqDescrip, AV23LiqClase, AV27LiqEstado, AV42TliqCod, AV8AplicaA, AV9auxLegNumero, AV24LiqDepBanCod, AV25LiqDepPrvFec, AV51LiqDepPerAno, AV52LiqDepPerMes, AV37LiqPerMes, AV35LiqPerAno, true, GXt_dtime5, AV53LiqPerPalabra, AV54LiqNombre, 0, "", "", DecimalUtil.doubleToDec(0), AV12clientId, AV55LiqSac, AV56LiqSacLog, AV74reliquidaEs, AV78LiqModTra, AV77LiqFrecPag, AV76LiqPerDes, AV75LiqPerHas, AV79LiqTipoTarifa, GXv_Sdtsdt_datos_liq6) ;
         AV57sdt_datos_liq = GXv_Sdtsdt_datos_liq6[0] ;
         AV57sdt_datos_liq.setgxTv_Sdtsdt_datos_liq_Replicanro( AV59replicaNro );
         new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV82Pgmname, httpContext.getMessage( "&sdt_datos_liq ", "")+AV57sdt_datos_liq.toJSonString(false, true)) ;
         if ( (GXutil.strcmp("", AV62QueueUrl)==0) )
         {
            callSubmit( 1 , new Object[]{ Integer.valueOf(AV11CliCod),Boolean.valueOf(true),AV57sdt_datos_liq });
         }
         else
         {
            if ( false )
            {
               GXv_SdtEventMessageResponse7[0] = AV64dummyEventMessageResponse;
               new web.lambda_calcliqtodo(remoteHandle, context).execute( "", GXv_SdtEventMessageResponse7) ;
               AV64dummyEventMessageResponse = GXv_SdtEventMessageResponse7[0] ;
            }
            GXv_char4[0] = AV63error ;
            new web.msgsqs(remoteHandle, context).execute( AV11CliCod, AV57sdt_datos_liq.toJSonString(false, true), AV62QueueUrl, "", GXv_char4) ;
            liquidacionporlotes.this.AV63error = GXv_char4[0] ;
            if ( ! (GXutil.strcmp("", AV63error)==0) )
            {
               GXv_boolean8[0] = false ;
               new web.liqseteaestadoyerror(remoteHandle, context).execute( AV11CliCod, AV15EmpCod, AV34LiqNro, AV63error, (byte)(2), (byte)(2), GXv_boolean8) ;
               new web.setliqcancel(remoteHandle, context).execute( AV11CliCod, AV15EmpCod, AV34LiqNro, true) ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV82Pgmname, "&2 ") ;
               new web.notificacionerrorliquidacion(remoteHandle, context).execute( AV11CliCod, AV15EmpCod, AV34LiqNro, AV12clientId) ;
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         AV18i = (short)(AV18i+AV10cantidadPorLote) ;
         AV47cantidadDeLotes = (short)(AV47cantidadDeLotes+1) ;
         if ( AV59replicaNro < ( AV60limiteReplicas - 1 ) )
         {
            AV59replicaNro = (short)(AV59replicaNro+1) ;
         }
         else
         {
            AV59replicaNro = (short)(0) ;
         }
      }
      AV61body_chequearLiquidacionFin.setgxTv_Sdtbody_chequearLiquidacionFin_Clicod( AV11CliCod );
      AV61body_chequearLiquidacionFin.setgxTv_Sdtbody_chequearLiquidacionFin_Empcod( AV15EmpCod );
      AV61body_chequearLiquidacionFin.setgxTv_Sdtbody_chequearLiquidacionFin_Liqnro( AV34LiqNro );
      AV61body_chequearLiquidacionFin.setgxTv_Sdtbody_chequearLiquidacionFin_Cantidadporlote( AV10cantidadPorLote );
      AV61body_chequearLiquidacionFin.setgxTv_Sdtbody_chequearLiquidacionFin_Cantidaddelotes( AV47cantidadDeLotes );
      AV61body_chequearLiquidacionFin.setgxTv_Sdtbody_chequearLiquidacionFin_Clientid( AV12clientId );
      AV61body_chequearLiquidacionFin.setgxTv_Sdtbody_chequearLiquidacionFin_Daemonuuid( AV57sdt_datos_liq.getgxTv_Sdtsdt_datos_liq_Daemonuuid() );
      new web.invocar_chequearliquidacionfin(remoteHandle, context).execute( GXutil.trim( AV61body_chequearLiquidacionFin.toJSonString(false, true))) ;
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void submit( int submitId ,
                       Object [] submitParms ,
                       ModelContext submitContext )
   {
      UserInformation submitUI = (UserInformation) GXObjectHelper.getUserInformation(context, -1);
      int remoteHandle = submitUI.getHandle();
      try
      {
         switch ( submitId )
         {
               case 1 :
                  new web.invocar_guardaliquidacion(remoteHandle, submitContext).execute( ((Number) submitParms[0]).intValue(), ((Boolean) submitParms[1]).booleanValue(), (web.Sdtsdt_datos_liq)submitParms[2]) ;
                  try { Application.getConnectionManager().disconnect(remoteHandle); } catch(Exception submitExc) { ; }
                  break;
         }
      }
      catch ( Exception e )
      {
         Application.cleanupConnection(remoteHandle);
         e.printStackTrace();
      }
   }

   public void initialize( )
   {
      AV65liqModoPalabra = "" ;
      GXt_char1 = "" ;
      GXt_char2 = "" ;
      GXv_char3 = new String[1] ;
      AV62QueueUrl = "" ;
      AV48ParmValue = "" ;
      AV82Pgmname = "" ;
      AV72aux = DecimalUtil.ZERO ;
      AV68parteDecimal = DecimalUtil.ZERO ;
      AV66auxCantidadPorLote = DecimalUtil.ZERO ;
      AV9auxLegNumero = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      AV57sdt_datos_liq = new web.Sdtsdt_datos_liq(remoteHandle, context);
      AV28LiqFecha = GXutil.nullDate() ;
      AV29LiqFecPago = GXutil.nullDate() ;
      AV26LiqDescrip = "" ;
      AV8AplicaA = "" ;
      AV24LiqDepBanCod = "" ;
      AV25LiqDepPrvFec = GXutil.nullDate() ;
      AV14dummDate = GXutil.nullDate() ;
      GXt_dtime5 = GXutil.resetTime( GXutil.nullDate() );
      AV53LiqPerPalabra = "" ;
      AV54LiqNombre = "" ;
      AV56LiqSacLog = "" ;
      GXv_Sdtsdt_datos_liq6 = new web.Sdtsdt_datos_liq[1] ;
      AV64dummyEventMessageResponse = new com.genexus.genexusserverlessapi.SdtEventMessageResponse(remoteHandle, context);
      GXv_SdtEventMessageResponse7 = new com.genexus.genexusserverlessapi.SdtEventMessageResponse[1] ;
      AV63error = "" ;
      GXv_char4 = new String[1] ;
      GXv_boolean8 = new boolean[1] ;
      AV61body_chequearLiquidacionFin = new web.Sdtbody_chequearLiquidacionFin(remoteHandle, context);
      AV82Pgmname = "LiquidacionPorLotes" ;
      /* GeneXus formulas. */
      AV82Pgmname = "LiquidacionPorLotes" ;
      Gx_err = (short)(0) ;
   }

   private byte AV23LiqClase ;
   private byte AV77LiqFrecPag ;
   private byte AV37LiqPerMes ;
   private byte AV27LiqEstado ;
   private byte AV52LiqDepPerMes ;
   private short AV15EmpCod ;
   private short AV35LiqPerAno ;
   private short AV60limiteReplicas ;
   private short AV10cantidadPorLote ;
   private short AV58cantidadLotesPorLiq ;
   private short AV70cantidadLotesMaxPorLiq ;
   private short AV18i ;
   private short AV20i2 ;
   private short AV17hasta ;
   private short AV51LiqDepPerAno ;
   private short AV59replicaNro ;
   private short AV47cantidadDeLotes ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV34LiqNro ;
   private int AV71trunc ;
   private int AV67truncCantidadPorLote ;
   private java.math.BigDecimal AV72aux ;
   private java.math.BigDecimal AV68parteDecimal ;
   private java.math.BigDecimal AV66auxCantidadPorLote ;
   private String AV78LiqModTra ;
   private String AV79LiqTipoTarifa ;
   private String AV42TliqCod ;
   private String AV65liqModoPalabra ;
   private String GXt_char1 ;
   private String GXt_char2 ;
   private String GXv_char3[] ;
   private String AV82Pgmname ;
   private String AV8AplicaA ;
   private String AV24LiqDepBanCod ;
   private String AV53LiqPerPalabra ;
   private String GXv_char4[] ;
   private java.util.Date GXt_dtime5 ;
   private java.util.Date AV76LiqPerDes ;
   private java.util.Date AV75LiqPerHas ;
   private java.util.Date AV28LiqFecha ;
   private java.util.Date AV29LiqFecPago ;
   private java.util.Date AV25LiqDepPrvFec ;
   private java.util.Date AV14dummDate ;
   private boolean AV74reliquidaEs ;
   private boolean AV55LiqSac ;
   private boolean GXv_boolean8[] ;
   private boolean returnInSub ;
   private String AV48ParmValue ;
   private String AV12clientId ;
   private String AV62QueueUrl ;
   private String AV26LiqDescrip ;
   private String AV54LiqNombre ;
   private String AV56LiqSacLog ;
   private String AV63error ;
   private GXSimpleCollection<Integer> AV21LegNumero ;
   private GXSimpleCollection<Integer> AV9auxLegNumero ;
   private web.Sdtbody_chequearLiquidacionFin AV61body_chequearLiquidacionFin ;
   private web.Sdtsdt_datos_liq AV57sdt_datos_liq ;
   private web.Sdtsdt_datos_liq GXv_Sdtsdt_datos_liq6[] ;
   private com.genexus.genexusserverlessapi.SdtEventMessageResponse AV64dummyEventMessageResponse ;
   private com.genexus.genexusserverlessapi.SdtEventMessageResponse GXv_SdtEventMessageResponse7[] ;
}

