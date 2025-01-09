package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class ejecutardeplsd extends GXProcedure
{
   public ejecutardeplsd( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ejecutardeplsd.class ), "" );
   }

   public ejecutardeplsd( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             GXSimpleCollection<Integer> aP3 ,
                             int aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String aP7 ,
                             String aP8 ,
                             String aP9 ,
                             String aP10 ,
                             String aP11 ,
                             GXSimpleCollection<Short> aP12 ,
                             String aP13 ,
                             String aP14 ,
                             short aP15 ,
                             String aP16 ,
                             boolean aP17 )
   {
      ejecutardeplsd.this.aP18 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18);
      return aP18[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        GXSimpleCollection<Integer> aP3 ,
                        int aP4 ,
                        String aP5 ,
                        String aP6 ,
                        String aP7 ,
                        String aP8 ,
                        String aP9 ,
                        String aP10 ,
                        String aP11 ,
                        GXSimpleCollection<Short> aP12 ,
                        String aP13 ,
                        String aP14 ,
                        short aP15 ,
                        String aP16 ,
                        boolean aP17 ,
                        String[] aP18 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             GXSimpleCollection<Integer> aP3 ,
                             int aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String aP7 ,
                             String aP8 ,
                             String aP9 ,
                             String aP10 ,
                             String aP11 ,
                             GXSimpleCollection<Short> aP12 ,
                             String aP13 ,
                             String aP14 ,
                             short aP15 ,
                             String aP16 ,
                             boolean aP17 ,
                             String[] aP18 )
   {
      ejecutardeplsd.this.AV10CliCod = aP0;
      ejecutardeplsd.this.AV11EmpCod = aP1;
      ejecutardeplsd.this.AV12LiqNro = aP2;
      ejecutardeplsd.this.AV35parmLegNumero = aP3;
      ejecutardeplsd.this.AV36unicoLegNumero = aP4;
      ejecutardeplsd.this.AV14LiqBatchCod = aP5;
      ejecutardeplsd.this.AV15ClientId = aP6;
      ejecutardeplsd.this.AV21microservicio = aP7;
      ejecutardeplsd.this.AV8liqModoPalabra = aP8;
      ejecutardeplsd.this.AV28parmsqsURL = aP9;
      ejecutardeplsd.this.AV27parmRestLocId = aP10;
      ejecutardeplsd.this.AV29parm_RestLocHab = aP11;
      ejecutardeplsd.this.AV32parmReplicas = aP12;
      ejecutardeplsd.this.AV30parmdesgloceEs = aP13;
      ejecutardeplsd.this.AV33ParmflujoGenRecPalabra = aP14;
      ejecutardeplsd.this.AV25iParm = aP15;
      ejecutardeplsd.this.AV38daemonUUID = aP16;
      ejecutardeplsd.this.AV41grabarLote = aP17;
      ejecutardeplsd.this.aP18 = aP18;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( (0==AV36unicoLegNumero) )
      {
         AV13LegNumero.fromJSonString(AV35parmLegNumero.toJSonString(false), null);
      }
      else
      {
         AV13LegNumero = new GXSimpleCollection<Integer>(Integer.class, "internal", "") ;
         AV13LegNumero.add((int)(AV36unicoLegNumero), 0);
      }
      if ( (GXutil.strcmp("", AV28parmsqsURL)==0) )
      {
         GXt_char1 = AV9sqsURL ;
         GXt_char2 = AV9sqsURL ;
         GXv_char3[0] = GXt_char2 ;
         new web.url_sqs_generarpdf_codigoparam(remoteHandle, context).execute( GXv_char3) ;
         ejecutardeplsd.this.GXt_char2 = GXv_char3[0] ;
         GXv_char4[0] = GXt_char1 ;
         new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char2, GXv_char4) ;
         ejecutardeplsd.this.GXt_char1 = GXv_char4[0] ;
         AV9sqsURL = GXt_char1 ;
      }
      else
      {
         AV9sqsURL = AV28parmsqsURL ;
      }
      if ( (GXutil.strcmp("", AV30parmdesgloceEs)==0) )
      {
         GXv_char4[0] = AV31ParmValue ;
         new web.getparametro(remoteHandle, context).execute( AV10CliCod, new web.lambda_desgloce_codigo(remoteHandle, context).executeUdp( ), GXv_char4) ;
         ejecutardeplsd.this.AV31ParmValue = GXv_char4[0] ;
         AV19desgloceEs = GXutil.boolval( AV31ParmValue) ;
      }
      else
      {
         AV19desgloceEs = GXutil.boolval( AV30parmdesgloceEs) ;
      }
      if ( (GXutil.strcmp("", AV29parm_RestLocHab)==0) )
      {
         GXv_boolean5[0] = AV18auxRestLocHab ;
         GXv_objcol_int6[0] = AV23auxReplicas ;
         new web.getrest_lochabyreplicas(remoteHandle, context).execute( AV10CliCod, AV27parmRestLocId, GXv_boolean5, GXv_objcol_int6) ;
         ejecutardeplsd.this.AV18auxRestLocHab = GXv_boolean5[0] ;
         AV23auxReplicas = GXv_objcol_int6[0] ;
      }
      else
      {
         AV18auxRestLocHab = GXutil.boolval( AV29parm_RestLocHab) ;
         AV23auxReplicas = AV32parmReplicas ;
      }
      if ( (GXutil.strcmp("", AV33ParmflujoGenRecPalabra)==0) )
      {
         GXt_char2 = AV20flujoGenRecPalabra ;
         GXt_char1 = AV20flujoGenRecPalabra ;
         GXv_char4[0] = GXt_char1 ;
         new web.flujo_gen_rec_codigoparam(remoteHandle, context).execute( GXv_char4) ;
         ejecutardeplsd.this.GXt_char1 = GXv_char4[0] ;
         GXv_char3[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char1, GXv_char3) ;
         ejecutardeplsd.this.GXt_char2 = GXv_char3[0] ;
         AV20flujoGenRecPalabra = GXt_char2 ;
      }
      else
      {
         AV20flujoGenRecPalabra = AV33ParmflujoGenRecPalabra ;
      }
      if ( ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV8liqModoPalabra)), httpContext.getMessage( "LAMBDA", "")) == 0 ) && ! (GXutil.strcmp("", AV9sqsURL)==0) )
      {
         GXt_char2 = AV37principalesModoPalabra ;
         GXt_char1 = AV37principalesModoPalabra ;
         GXv_char4[0] = GXt_char1 ;
         new web.liq_modo2_codigoparam(remoteHandle, context).execute( "liq_modo_prin", GXv_char4) ;
         ejecutardeplsd.this.GXt_char1 = GXv_char4[0] ;
         GXv_char3[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char1, GXv_char3) ;
         ejecutardeplsd.this.GXt_char2 = GXv_char3[0] ;
         AV37principalesModoPalabra = GXt_char2 ;
         if ( ( GXutil.strcmp(AV37principalesModoPalabra, httpContext.getMessage( "LAMBDA", "")) == 0 ) && ( GXutil.strcmp(AV20flujoGenRecPalabra, "3") == 0 ) )
         {
            new web.invocarlambdadirecto(remoteHandle, context).execute( AV10CliCod, httpContext.getMessage( "DEPLSD....", ""), httpContext.getMessage( "body", "")) ;
         }
         else
         {
            AV40modoPalabra = httpContext.getMessage( "LAMBDA", "") ;
            if ( AV41grabarLote )
            {
               /* Execute user subroutine: 'GRABA LOTE' */
               S131 ();
               if ( returnInSub )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
            GXv_Sdtsdt_datos_sec7[0] = AV16sdt_datos_sec;
            new web.armarsdtdatossec(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV12LiqNro, AV13LegNumero, AV14LiqBatchCod, AV15ClientId, httpContext.getMessage( "DEPENDENCIAS_LSD", ""), GXv_Sdtsdt_datos_sec7) ;
            AV16sdt_datos_sec = GXv_Sdtsdt_datos_sec7[0] ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV44Pgmname, httpContext.getMessage( "llama a sqs de DEPLSD", "")) ;
            GXv_char4[0] = AV17error ;
            new web.msgsqs(remoteHandle, context).execute( AV10CliCod, AV16sdt_datos_sec.toJSonString(false, true), AV9sqsURL, "", GXv_char4) ;
            ejecutardeplsd.this.AV17error = GXv_char4[0] ;
         }
      }
      else
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV44Pgmname, httpContext.getMessage( "ejecutar deplsd &&auxRestLocHab ", "")+GXutil.trim( GXutil.booltostr( AV18auxRestLocHab))+httpContext.getMessage( " &liqModoPalabra ", "")+AV8liqModoPalabra+httpContext.getMessage( " &desgloceEs ", "")+GXutil.trim( GXutil.booltostr( AV19desgloceEs))+httpContext.getMessage( " &flujoGenRecPalabra ", "")+AV20flujoGenRecPalabra) ;
         if ( ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV8liqModoPalabra)), httpContext.getMessage( "DOCKER", "")) == 0 ) && ( AV18auxRestLocHab ) && ( AV19desgloceEs ) )
         {
            AV21microservicio = "" ;
            AV22replicas = AV23auxReplicas ;
            AV24iReplica = AV25iParm ;
            AV26RestLocId = AV27parmRestLocId ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV44Pgmname, httpContext.getMessage( "ejecu", "")) ;
            /* Execute user subroutine: 'INVOCAR REST' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else
         {
            AV39falloDaemon = false ;
            if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV8liqModoPalabra)), httpContext.getMessage( "DAEMON", "")) == 0 )
            {
               GXt_boolean8 = AV39falloDaemon ;
               GXv_boolean5[0] = GXt_boolean8 ;
               new web.daemonvalido(remoteHandle, context).execute( AV38daemonUUID, true, GXv_boolean5) ;
               ejecutardeplsd.this.GXt_boolean8 = GXv_boolean5[0] ;
               AV39falloDaemon = (boolean)(!GXt_boolean8) ;
            }
            if ( ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV8liqModoPalabra)), httpContext.getMessage( "DAEMON", "")) == 0 ) && ! AV39falloDaemon )
            {
               /* Execute user subroutine: 'ARMA SDT' */
               S121 ();
               if ( returnInSub )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               AV40modoPalabra = AV38daemonUUID ;
               if ( AV41grabarLote )
               {
                  /* Execute user subroutine: 'GRABA LOTE' */
                  S131 ();
                  if ( returnInSub )
                  {
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
               }
               new web.newcola(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV12LiqNro, (byte)(0), "DEPENDENCIAS_LSD", AV16sdt_datos_sec.toJSonString(false, true), AV38daemonUUID) ;
            }
            else
            {
               if ( ( AV39falloDaemon ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV8liqModoPalabra)), httpContext.getMessage( "MONOLITICO", "")) == 0 ) )
               {
                  AV40modoPalabra = httpContext.getMessage( "LOCAL", "") ;
                  if ( AV39falloDaemon )
                  {
                     AV40modoPalabra += httpContext.getMessage( " (falló DAEMON)", "") ;
                  }
                  if ( AV41grabarLote )
                  {
                     /* Execute user subroutine: 'GRABA LOTE' */
                     S131 ();
                     if ( returnInSub )
                     {
                        returnInSub = true;
                        cleanup();
                        if (true) return;
                     }
                  }
                  new web.procesossecundarios(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV12LiqNro, AV13LegNumero, 0, AV15ClientId, AV14LiqBatchCod, httpContext.getMessage( "DEPENDENCIAS_LSD", ""), false, AV40modoPalabra) ;
               }
            }
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'INVOCAR REST' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'ARMA SDT' */
      S121 ();
      if (returnInSub) return;
      GXv_int9[0] = AV24iReplica ;
      GXv_int10[0] = AV34replicaNro ;
      new web.getnextreplicanro(remoteHandle, context).execute( AV22replicas, GXv_int9, GXv_int10) ;
      ejecutardeplsd.this.AV24iReplica = GXv_int9[0] ;
      ejecutardeplsd.this.AV34replicaNro = GXv_int10[0] ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV44Pgmname, httpContext.getMessage( "ejecu &sdt_datos_sec ", "")+AV16sdt_datos_sec.toJSonString(false, true)) ;
      GXv_boolean5[0] = false ;
      GXv_char4[0] = AV17error ;
      new web.invocar_rest_conreplica(remoteHandle, context).execute( AV10CliCod, AV26RestLocId, AV34replicaNro, AV16sdt_datos_sec.toJSonString(false, true), GXv_boolean5, GXv_char4) ;
      ejecutardeplsd.this.AV17error = GXv_char4[0] ;
      if ( ! (GXutil.strcmp("", AV17error)==0) )
      {
         System.out.println( httpContext.getMessage( "No se pudo ejecutar el microservicio http de dependencias lsd, se ejecuta en modo local (", "")+GXutil.trim( AV17error)+httpContext.getMessage( "), req: ", "")+GXutil.trim( AV16sdt_datos_sec.toJSonString(false, true)) );
         AV17error = "" ;
         AV40modoPalabra = httpContext.getMessage( "LOCAL (falló HTTP)", "") ;
         if ( AV41grabarLote )
         {
            /* Execute user subroutine: 'GRABA LOTE' */
            S131 ();
            if (returnInSub) return;
         }
         new web.procesossecundarios(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV12LiqNro, AV13LegNumero, 0, AV15ClientId, AV14LiqBatchCod, httpContext.getMessage( "DEPENDENCIAS_LSD", ""), false, AV40modoPalabra) ;
      }
      else
      {
         AV40modoPalabra = httpContext.getMessage( "HTTP", "") ;
         if ( AV41grabarLote )
         {
            /* Execute user subroutine: 'GRABA LOTE' */
            S131 ();
            if (returnInSub) return;
         }
      }
   }

   public void S121( )
   {
      /* 'ARMA SDT' Routine */
      returnInSub = false ;
      GXv_Sdtsdt_datos_sec7[0] = AV16sdt_datos_sec;
      new web.armarsdtdatossec(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV12LiqNro, AV13LegNumero, AV14LiqBatchCod, AV15ClientId, AV21microservicio, GXv_Sdtsdt_datos_sec7) ;
      AV16sdt_datos_sec = GXv_Sdtsdt_datos_sec7[0] ;
   }

   public void S131( )
   {
      /* 'GRABA LOTE' Routine */
      returnInSub = false ;
      new web.grabaliquidacionlote(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV12LiqNro, AV14LiqBatchCod, httpContext.getMessage( "DEPENDENCIAS_LSD", ""), (short)(1), "", AV13LegNumero, AV40modoPalabra) ;
   }

   protected void cleanup( )
   {
      this.aP18[0] = ejecutardeplsd.this.AV17error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV17error = "" ;
      AV13LegNumero = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      AV9sqsURL = "" ;
      AV31ParmValue = "" ;
      AV23auxReplicas = new GXSimpleCollection<Short>(Short.class, "internal", "");
      GXv_objcol_int6 = new GXSimpleCollection[1] ;
      AV20flujoGenRecPalabra = "" ;
      AV37principalesModoPalabra = "" ;
      GXt_char2 = "" ;
      GXt_char1 = "" ;
      GXv_char3 = new String[1] ;
      AV40modoPalabra = "" ;
      AV16sdt_datos_sec = new web.Sdtsdt_datos_sec(remoteHandle, context);
      AV44Pgmname = "" ;
      AV22replicas = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV26RestLocId = "" ;
      GXv_int9 = new short[1] ;
      GXv_int10 = new short[1] ;
      GXv_boolean5 = new boolean[1] ;
      GXv_char4 = new String[1] ;
      GXv_Sdtsdt_datos_sec7 = new web.Sdtsdt_datos_sec[1] ;
      AV44Pgmname = "ejecutarDepLSD" ;
      /* GeneXus formulas. */
      AV44Pgmname = "ejecutarDepLSD" ;
      Gx_err = (short)(0) ;
   }

   private short AV11EmpCod ;
   private short AV25iParm ;
   private short AV24iReplica ;
   private short GXv_int9[] ;
   private short AV34replicaNro ;
   private short GXv_int10[] ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV12LiqNro ;
   private int AV36unicoLegNumero ;
   private String AV21microservicio ;
   private String AV8liqModoPalabra ;
   private String AV27parmRestLocId ;
   private String AV29parm_RestLocHab ;
   private String AV30parmdesgloceEs ;
   private String AV33ParmflujoGenRecPalabra ;
   private String AV38daemonUUID ;
   private String AV20flujoGenRecPalabra ;
   private String AV37principalesModoPalabra ;
   private String GXt_char2 ;
   private String GXt_char1 ;
   private String GXv_char3[] ;
   private String AV40modoPalabra ;
   private String AV44Pgmname ;
   private String AV26RestLocId ;
   private String GXv_char4[] ;
   private boolean AV41grabarLote ;
   private boolean AV19desgloceEs ;
   private boolean AV18auxRestLocHab ;
   private boolean returnInSub ;
   private boolean AV39falloDaemon ;
   private boolean GXt_boolean8 ;
   private boolean GXv_boolean5[] ;
   private String AV31ParmValue ;
   private String AV14LiqBatchCod ;
   private String AV15ClientId ;
   private String AV28parmsqsURL ;
   private String AV17error ;
   private String AV9sqsURL ;
   private GXSimpleCollection<Short> AV32parmReplicas ;
   private GXSimpleCollection<Short> AV23auxReplicas ;
   private GXSimpleCollection<Short> GXv_objcol_int6[] ;
   private GXSimpleCollection<Short> AV22replicas ;
   private GXSimpleCollection<Integer> AV35parmLegNumero ;
   private GXSimpleCollection<Integer> AV13LegNumero ;
   private String[] aP18 ;
   private web.Sdtsdt_datos_sec AV16sdt_datos_sec ;
   private web.Sdtsdt_datos_sec GXv_Sdtsdt_datos_sec7[] ;
}

