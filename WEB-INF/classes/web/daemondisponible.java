package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class daemondisponible extends GXProcedure
{
   public daemondisponible( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( daemondisponible.class ), "" );
   }

   public daemondisponible( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 )
   {
      daemondisponible.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String[] aP2 )
   {
      daemondisponible.this.AV8CliCod = aP0;
      daemondisponible.this.AV10microservicio = aP1;
      daemondisponible.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( GXutil.strcmp(AV10microservicio, "GuardaLiquidacion") == 0 )
      {
         GXt_char1 = AV11liqModoPalabra ;
         GXt_char2 = AV11liqModoPalabra ;
         GXv_char3[0] = GXt_char2 ;
         new web.liq_modo2_codigoparam(remoteHandle, context).execute( "liq_modo_prin", GXv_char3) ;
         daemondisponible.this.GXt_char2 = GXv_char3[0] ;
         GXv_char4[0] = GXt_char1 ;
         new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char2, GXv_char4) ;
         daemondisponible.this.GXt_char1 = GXv_char4[0] ;
         AV11liqModoPalabra = GXt_char1 ;
      }
      else if ( GXutil.strcmp(AV10microservicio, "DEPENDENCIAS_LSD") == 0 )
      {
         GXt_char2 = AV11liqModoPalabra ;
         GXt_char1 = AV11liqModoPalabra ;
         GXv_char4[0] = GXt_char1 ;
         new web.liq_modo2_codigoparam(remoteHandle, context).execute( "liq_modo_lsd", GXv_char4) ;
         daemondisponible.this.GXt_char1 = GXv_char4[0] ;
         GXv_char3[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
         daemondisponible.this.GXt_char2 = GXv_char3[0] ;
         AV11liqModoPalabra = GXt_char2 ;
      }
      else if ( GXutil.strcmp(AV10microservicio, "CONTRIBUCIONES") == 0 )
      {
         GXt_char2 = AV11liqModoPalabra ;
         GXt_char1 = AV11liqModoPalabra ;
         GXv_char4[0] = GXt_char1 ;
         new web.liq_modo2_codigoparam(remoteHandle, context).execute( "liq_modo_contr", GXv_char4) ;
         daemondisponible.this.GXt_char1 = GXv_char4[0] ;
         GXv_char3[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
         daemondisponible.this.GXt_char2 = GXv_char3[0] ;
         AV11liqModoPalabra = GXt_char2 ;
      }
      else if ( GXutil.strcmp(AV10microservicio, "OTROS") == 0 )
      {
         GXt_char2 = AV11liqModoPalabra ;
         GXt_char1 = AV11liqModoPalabra ;
         GXv_char4[0] = GXt_char1 ;
         new web.liq_modo2_codigoparam(remoteHandle, context).execute( "liq_modo_otros", GXv_char4) ;
         daemondisponible.this.GXt_char1 = GXv_char4[0] ;
         GXv_char3[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
         daemondisponible.this.GXt_char2 = GXv_char3[0] ;
         AV11liqModoPalabra = GXt_char2 ;
      }
      else if ( GXutil.strcmp(AV10microservicio, "GENERACION_PDFS") == 0 )
      {
         GXt_char2 = AV11liqModoPalabra ;
         GXt_char1 = AV11liqModoPalabra ;
         GXv_char4[0] = GXt_char1 ;
         new web.liq_modo2_codigoparam(remoteHandle, context).execute( "liq_modo_recibos", GXv_char4) ;
         daemondisponible.this.GXt_char1 = GXv_char4[0] ;
         GXv_char3[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
         daemondisponible.this.GXt_char2 = GXv_char3[0] ;
         AV11liqModoPalabra = GXt_char2 ;
      }
      else if ( GXutil.strcmp(AV10microservicio, "CREARPDF") == 0 )
      {
         GXt_char2 = AV11liqModoPalabra ;
         GXt_char1 = AV11liqModoPalabra ;
         GXv_char4[0] = GXt_char1 ;
         new web.liq_modo2_codigoparam(remoteHandle, context).execute( "liq_modo_pdf", GXv_char4) ;
         daemondisponible.this.GXt_char1 = GXv_char4[0] ;
         GXv_char3[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
         daemondisponible.this.GXt_char2 = GXv_char3[0] ;
         AV11liqModoPalabra = GXt_char2 ;
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV17Pgmname, httpContext.getMessage( "microservicio ", "")+GXutil.trim( AV10microservicio)+httpContext.getMessage( " modo ", "")+GXutil.trim( AV11liqModoPalabra)) ;
      if ( GXutil.strcmp(AV11liqModoPalabra, httpContext.getMessage( "DAEMON", "")) == 0 )
      {
         GXv_char4[0] = AV14MetaParmValue ;
         new web.getmetaparmvalue(remoteHandle, context).execute( httpContext.getMessage( "env", ""), GXv_char4) ;
         daemondisponible.this.AV14MetaParmValue = GXv_char4[0] ;
         if ( GXutil.strcmp(GXutil.trim( AV14MetaParmValue), httpContext.getMessage( "desa", "")) == 0 )
         {
            GXt_dtime5 = AV13ahora ;
            GXv_dtime6[0] = GXt_dtime5 ;
            new web.getahoralocal(remoteHandle, context).execute( AV8CliCod, GXv_dtime6) ;
            daemondisponible.this.GXt_dtime5 = GXv_dtime6[0] ;
            AV13ahora = GXt_dtime5 ;
         }
         else
         {
            if ( GXutil.strcmp(AV10microservicio, "CREARPDF") == 0 )
            {
               GXt_dtime5 = AV13ahora ;
               GXv_dtime6[0] = GXt_dtime5 ;
               new web.getahora(remoteHandle, context).execute( AV8CliCod, GXv_dtime6) ;
               daemondisponible.this.GXt_dtime5 = GXv_dtime6[0] ;
               AV13ahora = GXt_dtime5 ;
            }
            else
            {
               GXt_dtime5 = AV13ahora ;
               GXv_dtime6[0] = GXt_dtime5 ;
               new web.getahoralocal(remoteHandle, context).execute( AV8CliCod, GXv_dtime6) ;
               daemondisponible.this.GXt_dtime5 = GXv_dtime6[0] ;
               AV13ahora = GXt_dtime5 ;
            }
         }
         AV12daemonDT = GXutil.dtadd( AV13ahora, 60*(-1)) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV17Pgmname, httpContext.getMessage( "busca con ", "")+GXutil.trim( localUtil.ttoc( AV12daemonDT, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "))) ;
         AV18GXLvl46 = (byte)(0) ;
         /* Using cursor P02J92 */
         pr_default.execute(0, new Object[] {AV10microservicio, AV12daemonDT});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A2386daemonDT = P02J92_A2386daemonDT[0] ;
            A2385daemonMicroservicio = P02J92_A2385daemonMicroservicio[0] ;
            A2384daemonUUID = P02J92_A2384daemonUUID[0] ;
            A2403daemonCount = P02J92_A2403daemonCount[0] ;
            AV18GXLvl46 = (byte)(1) ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV17Pgmname, httpContext.getMessage( "encuentra daemonDT ", "")+GXutil.trim( localUtil.ttoc( A2386daemonDT, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "))) ;
            AV9daemonUUID = A2384daemonUUID ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            pr_default.readNext(0);
         }
         pr_default.close(0);
         if ( AV18GXLvl46 == 0 )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV17Pgmname, httpContext.getMessage( "no encuentra", "")) ;
         }
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV17Pgmname, httpContext.getMessage( "&daemonUUID ", "")+GXutil.trim( AV9daemonUUID)) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = daemondisponible.this.AV9daemonUUID;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9daemonUUID = "" ;
      AV11liqModoPalabra = "" ;
      GXt_char2 = "" ;
      GXt_char1 = "" ;
      GXv_char3 = new String[1] ;
      AV17Pgmname = "" ;
      AV14MetaParmValue = "" ;
      GXv_char4 = new String[1] ;
      AV13ahora = GXutil.resetTime( GXutil.nullDate() );
      GXt_dtime5 = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime6 = new java.util.Date[1] ;
      AV12daemonDT = GXutil.resetTime( GXutil.nullDate() );
      scmdbuf = "" ;
      P02J92_A2386daemonDT = new java.util.Date[] {GXutil.nullDate()} ;
      P02J92_A2385daemonMicroservicio = new String[] {""} ;
      P02J92_A2384daemonUUID = new String[] {""} ;
      P02J92_A2403daemonCount = new int[1] ;
      A2386daemonDT = GXutil.resetTime( GXutil.nullDate() );
      A2385daemonMicroservicio = "" ;
      A2384daemonUUID = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.daemondisponible__default(),
         new Object[] {
             new Object[] {
            P02J92_A2386daemonDT, P02J92_A2385daemonMicroservicio, P02J92_A2384daemonUUID, P02J92_A2403daemonCount
            }
         }
      );
      AV17Pgmname = "daemonDisponible" ;
      /* GeneXus formulas. */
      AV17Pgmname = "daemonDisponible" ;
      Gx_err = (short)(0) ;
   }

   private byte AV18GXLvl46 ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A2403daemonCount ;
   private String AV10microservicio ;
   private String AV9daemonUUID ;
   private String AV11liqModoPalabra ;
   private String GXt_char2 ;
   private String GXt_char1 ;
   private String GXv_char3[] ;
   private String AV17Pgmname ;
   private String GXv_char4[] ;
   private String scmdbuf ;
   private String A2385daemonMicroservicio ;
   private String A2384daemonUUID ;
   private java.util.Date AV13ahora ;
   private java.util.Date GXt_dtime5 ;
   private java.util.Date GXv_dtime6[] ;
   private java.util.Date AV12daemonDT ;
   private java.util.Date A2386daemonDT ;
   private String AV14MetaParmValue ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] P02J92_A2386daemonDT ;
   private String[] P02J92_A2385daemonMicroservicio ;
   private String[] P02J92_A2384daemonUUID ;
   private int[] P02J92_A2403daemonCount ;
}

final  class daemondisponible__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02J92", "SELECT daemonDT, daemonMicroservicio, daemonUUID, daemonCount FROM daemon WHERE (daemonMicroservicio = ( ?)) AND (daemonDT >= ?) ORDER BY daemonMicroservicio, daemonCount, daemonDT DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDateTime(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 36);
               ((int[]) buf[3])[0] = rslt.getInt(4);
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
               stmt.setString(1, (String)parms[0], 20);
               stmt.setDateTime(2, (java.util.Date)parms[1], false);
               return;
      }
   }

}

