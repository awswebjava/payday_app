package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class procesossecundarios extends GXProcedure
{
   public procesossecundarios( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( procesossecundarios.class ), "" );
   }

   public procesossecundarios( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        GXSimpleCollection<Integer> aP3 ,
                        int aP4 ,
                        String aP5 ,
                        String aP6 ,
                        String aP7 ,
                        boolean aP8 ,
                        String aP9 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             GXSimpleCollection<Integer> aP3 ,
                             int aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String aP7 ,
                             boolean aP8 ,
                             String aP9 )
   {
      procesossecundarios.this.AV8CliCod = aP0;
      procesossecundarios.this.AV9EmpCod = aP1;
      procesossecundarios.this.AV11LiqNro = aP2;
      procesossecundarios.this.AV32parmLegNumero = aP3;
      procesossecundarios.this.AV33unicoLegNumero = aP4;
      procesossecundarios.this.AV12clientId = aP5;
      procesossecundarios.this.AV13LiqLote = aP6;
      procesossecundarios.this.AV20ejecutarSolo = aP7;
      procesossecundarios.this.AV29forzarSincrono = aP8;
      procesossecundarios.this.AV31solodaemonUUID = aP9;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( (0==AV33unicoLegNumero) )
      {
         AV10LegNumero.fromJSonString(AV32parmLegNumero.toJSonString(false), null);
      }
      else
      {
         AV10LegNumero = new GXSimpleCollection<Integer>(Integer.class, "internal", "") ;
         AV10LegNumero.add((int)(AV33unicoLegNumero), 0);
      }
      GXt_char1 = AV28liqPrinModoPalabra ;
      GXt_char2 = AV28liqPrinModoPalabra ;
      GXv_char3[0] = GXt_char2 ;
      new web.liq_modo2_codigoparam(remoteHandle, context).execute( "liq_modo_prin", GXv_char3) ;
      procesossecundarios.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char2, GXv_char4) ;
      procesossecundarios.this.GXt_char1 = GXv_char4[0] ;
      AV28liqPrinModoPalabra = GXt_char1 ;
      GXt_char2 = AV25liqLSDModoPalabra ;
      GXt_char1 = AV25liqLSDModoPalabra ;
      GXv_char4[0] = GXt_char1 ;
      new web.liq_modo2_codigoparam(remoteHandle, context).execute( "liq_modo_lsd", GXv_char4) ;
      procesossecundarios.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      procesossecundarios.this.GXt_char2 = GXv_char3[0] ;
      AV25liqLSDModoPalabra = GXt_char2 ;
      GXt_char2 = AV26liqContrModoPalabra ;
      GXt_char1 = AV26liqContrModoPalabra ;
      GXv_char4[0] = GXt_char1 ;
      new web.liq_modo2_codigoparam(remoteHandle, context).execute( "liq_modo_contr", GXv_char4) ;
      procesossecundarios.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      procesossecundarios.this.GXt_char2 = GXv_char3[0] ;
      AV26liqContrModoPalabra = GXt_char2 ;
      GXt_char2 = AV27liqOtrosModoPalabra ;
      GXt_char1 = AV27liqOtrosModoPalabra ;
      GXv_char4[0] = GXt_char1 ;
      new web.liq_modo2_codigoparam(remoteHandle, context).execute( "liq_modo_otros", GXv_char4) ;
      procesossecundarios.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      procesossecundarios.this.GXt_char2 = GXv_char3[0] ;
      AV27liqOtrosModoPalabra = GXt_char2 ;
      GXv_char4[0] = AV17ParmValue ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, new web.lambda_desgloce_codigo(remoteHandle, context).executeUdp( ), GXv_char4) ;
      procesossecundarios.this.AV17ParmValue = GXv_char4[0] ;
      AV18desgloceEs = GXutil.boolval( AV17ParmValue) ;
      AV22ejecutarLSD = (short)((byte)((true)?1:0)) ;
      AV23ejecutarContr = true ;
      AV24ejecutarOtros = true ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV37Pgmname, "1") ;
      if ( (GXutil.strcmp("", AV20ejecutarSolo)==0) )
      {
         if ( GXutil.strcmp(AV28liqPrinModoPalabra, httpContext.getMessage( "MONOLITICO", "")) != 0 )
         {
            AV22ejecutarLSD = (short)((byte)((false)?1:0)) ;
            AV23ejecutarContr = false ;
            AV24ejecutarOtros = false ;
         }
         else
         {
            if ( GXutil.strcmp(AV25liqLSDModoPalabra, httpContext.getMessage( "MONOLITICO", "")) != 0 )
            {
               AV22ejecutarLSD = (short)((byte)((false)?1:0)) ;
            }
            if ( GXutil.strcmp(AV26liqContrModoPalabra, httpContext.getMessage( "MONOLITICO", "")) != 0 )
            {
               AV23ejecutarContr = false ;
            }
            if ( GXutil.strcmp(AV27liqOtrosModoPalabra, httpContext.getMessage( "MONOLITICO", "")) != 0 )
            {
               AV24ejecutarOtros = false ;
            }
         }
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV37Pgmname, httpContext.getMessage( "2 &ejecutarSolo ", "")+AV20ejecutarSolo+httpContext.getMessage( " &&ejecutarLSD ", "")+GXutil.trim( GXutil.str( AV22ejecutarLSD, 4, 0))) ;
      if ( ( AV22ejecutarLSD == ( 1 )) && ( (GXutil.strcmp("", AV20ejecutarSolo)==0) || ( GXutil.strcmp(AV20ejecutarSolo, httpContext.getMessage( "DEPENDENCIAS_LSD", "")) == 0 ) ) )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV37Pgmname, httpContext.getMessage( "3 llama a dependencias lsd", "")) ;
         GXv_int5[0] = AV14LiqLSDDepEst ;
         new web.getliqestdeplsd(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV11LiqNro, GXv_int5) ;
         procesossecundarios.this.AV14LiqLSDDepEst = GXv_int5[0] ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV37Pgmname, "4") ;
         if ( AV14LiqLSDDepEst != 1 )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV37Pgmname, "5") ;
            new web.setliqestdeplsd(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV11LiqNro, (byte)(1)) ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV37Pgmname, "6") ;
         }
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV37Pgmname, "7") ;
         if ( (GXutil.strcmp("", AV31solodaemonUUID)==0) )
         {
            GXv_char4[0] = AV30daemonUUID ;
            new web.daemondisponible(remoteHandle, context).execute( AV8CliCod, "DEPENDENCIAS_LSD", GXv_char4) ;
            procesossecundarios.this.AV30daemonUUID = GXv_char4[0] ;
            /* Execute user subroutine: 'DAEMON VALIDO' */
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
            AV30daemonUUID = AV31solodaemonUUID ;
         }
         new web.procesossegundoplanoporlote(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV11LiqNro, AV10LegNumero, AV12clientId, false, AV13LiqLote, httpContext.getMessage( "DEPENDENCIAS_LSD", ""), AV29forzarSincrono, AV30daemonUUID) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV37Pgmname, "8") ;
      }
      if ( ( AV23ejecutarContr ) && ( (GXutil.strcmp("", AV20ejecutarSolo)==0) || ( GXutil.strcmp(AV20ejecutarSolo, httpContext.getMessage( "CONTRIBUCIONES", "")) == 0 ) ) )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV37Pgmname, httpContext.getMessage( "llama a contribuciones", "")) ;
         GXv_int5[0] = AV15LiqContrEst ;
         new web.getliqestcontr(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV11LiqNro, GXv_int5) ;
         procesossecundarios.this.AV15LiqContrEst = GXv_int5[0] ;
         if ( AV15LiqContrEst != 1 )
         {
            new web.setliqestcontr(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV11LiqNro, (byte)(1)) ;
         }
         if ( (GXutil.strcmp("", AV31solodaemonUUID)==0) )
         {
            GXv_char4[0] = AV30daemonUUID ;
            new web.daemondisponible(remoteHandle, context).execute( AV8CliCod, "CONTRIBUCIONES", GXv_char4) ;
            procesossecundarios.this.AV30daemonUUID = GXv_char4[0] ;
            /* Execute user subroutine: 'DAEMON VALIDO' */
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
            AV30daemonUUID = AV31solodaemonUUID ;
         }
         new web.procesossegundoplanoporlote(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV11LiqNro, AV10LegNumero, AV12clientId, false, AV13LiqLote, httpContext.getMessage( "CONTRIBUCIONES", ""), AV29forzarSincrono, AV30daemonUUID) ;
      }
      if ( ( AV24ejecutarOtros ) && ( (GXutil.strcmp("", AV20ejecutarSolo)==0) || ( GXutil.strcmp(AV20ejecutarSolo, httpContext.getMessage( "OTROS", "")) == 0 ) ) )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV37Pgmname, httpContext.getMessage( "llama a otros", "")) ;
         GXv_int5[0] = AV16LiqAuxEstado ;
         new web.getliqestadoaux(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV11LiqNro, GXv_int5) ;
         procesossecundarios.this.AV16LiqAuxEstado = GXv_int5[0] ;
         if ( AV16LiqAuxEstado != 1 )
         {
            new web.setliqestadoaux(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV11LiqNro, (byte)(1)) ;
         }
         if ( (GXutil.strcmp("", AV31solodaemonUUID)==0) )
         {
            GXv_char4[0] = AV30daemonUUID ;
            new web.daemondisponible(remoteHandle, context).execute( AV8CliCod, "OTROS", GXv_char4) ;
            procesossecundarios.this.AV30daemonUUID = GXv_char4[0] ;
            /* Execute user subroutine: 'DAEMON VALIDO' */
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
            AV30daemonUUID = AV31solodaemonUUID ;
         }
         new web.procesossegundoplanoporlote(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV11LiqNro, AV10LegNumero, AV12clientId, false, AV13LiqLote, httpContext.getMessage( "OTROS", ""), AV29forzarSincrono, AV30daemonUUID) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV37Pgmname, httpContext.getMessage( "llamó a otros ...", "")) ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'DAEMON VALIDO' Routine */
      returnInSub = false ;
      GXv_boolean6[0] = true ;
      new web.daemonvalido(remoteHandle, context).execute( AV30daemonUUID, AV34validoEs, GXv_boolean6) ;
      if ( ! AV34validoEs )
      {
         AV30daemonUUID = httpContext.getMessage( "LOCAL", "") ;
      }
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
   public void initialize( )
   {
      AV10LegNumero = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      AV28liqPrinModoPalabra = "" ;
      AV25liqLSDModoPalabra = "" ;
      AV26liqContrModoPalabra = "" ;
      AV27liqOtrosModoPalabra = "" ;
      GXt_char2 = "" ;
      GXt_char1 = "" ;
      GXv_char3 = new String[1] ;
      AV17ParmValue = "" ;
      AV37Pgmname = "" ;
      AV30daemonUUID = "" ;
      GXv_int5 = new byte[1] ;
      GXv_char4 = new String[1] ;
      GXv_boolean6 = new boolean[1] ;
      AV37Pgmname = "procesosSecundarios" ;
      /* GeneXus formulas. */
      AV37Pgmname = "procesosSecundarios" ;
      Gx_err = (short)(0) ;
   }

   private byte AV14LiqLSDDepEst ;
   private byte AV15LiqContrEst ;
   private byte AV16LiqAuxEstado ;
   private byte GXv_int5[] ;
   private short AV9EmpCod ;
   private short AV22ejecutarLSD ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV11LiqNro ;
   private int AV33unicoLegNumero ;
   private String AV20ejecutarSolo ;
   private String AV31solodaemonUUID ;
   private String AV28liqPrinModoPalabra ;
   private String AV25liqLSDModoPalabra ;
   private String AV26liqContrModoPalabra ;
   private String AV27liqOtrosModoPalabra ;
   private String GXt_char2 ;
   private String GXt_char1 ;
   private String GXv_char3[] ;
   private String AV37Pgmname ;
   private String AV30daemonUUID ;
   private String GXv_char4[] ;
   private boolean AV29forzarSincrono ;
   private boolean AV18desgloceEs ;
   private boolean AV23ejecutarContr ;
   private boolean AV24ejecutarOtros ;
   private boolean returnInSub ;
   private boolean AV34validoEs ;
   private boolean GXv_boolean6[] ;
   private String AV17ParmValue ;
   private String AV12clientId ;
   private String AV13LiqLote ;
   private GXSimpleCollection<Integer> AV32parmLegNumero ;
   private GXSimpleCollection<Integer> AV10LegNumero ;
}

