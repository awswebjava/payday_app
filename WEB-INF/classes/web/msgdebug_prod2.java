package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class msgdebug_prod2 extends GXProcedure
{
   public msgdebug_prod2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( msgdebug_prod2.class ), "" );
   }

   public msgdebug_prod2( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 )
   {
      msgdebug_prod2.this.AV13CliCod = aP0;
      msgdebug_prod2.this.AV8programa = aP1;
      msgdebug_prod2.this.AV10mensaje = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_dtime1 = AV9ahoraDateTime ;
      GXv_dtime2[0] = GXt_dtime1 ;
      new web.getahora(remoteHandle, context).execute( AV13CliCod, GXv_dtime2) ;
      msgdebug_prod2.this.GXt_dtime1 = GXv_dtime2[0] ;
      AV9ahoraDateTime = GXutil.resetMillis(GXt_dtime1) ;
      if ( (0==AV13CliCod) )
      {
         System.out.println( GXutil.trim( AV8programa)+httpContext.getMessage( " (clicod empty) ", "")+GXutil.trim( localUtil.ttoc( AV9ahoraDateTime, 8, 8, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "))+" "+AV10mensaje );
      }
      else
      {
         GXv_char3[0] = AV14nivelDebugPalabra ;
         new web.getparametro(remoteHandle, context).execute( AV13CliCod, new web.niveldebug_codigoparam(remoteHandle, context).executeUdp( ), GXv_char3) ;
         msgdebug_prod2.this.AV14nivelDebugPalabra = GXv_char3[0] ;
         if ( ( GXutil.strcmp(AV14nivelDebugPalabra, httpContext.getMessage( "NADA", "")) != 0 ) && ! (GXutil.strcmp("", AV14nivelDebugPalabra)==0) )
         {
            if ( GXutil.strcmp(GXutil.trim( GXutil.upper( AV14nivelDebugPalabra)), httpContext.getMessage( "ESPECIFICO", "")) == 0 )
            {
               /* Using cursor P029C2 */
               pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), AV8programa});
               while ( (pr_default.getStatus(0) != 101) )
               {
                  A1755DebugActivo = P029C2_A1755DebugActivo[0] ;
                  A1754DebugPgm = P029C2_A1754DebugPgm[0] ;
                  A3CliCod = P029C2_A3CliCod[0] ;
                  System.out.println( GXutil.trim( AV8programa)+httpContext.getMessage( " (especifico) ", "")+GXutil.trim( localUtil.ttoc( AV9ahoraDateTime, 8, 8, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "))+" "+AV10mensaje );
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  pr_default.readNext(0);
               }
               pr_default.close(0);
            }
            else
            {
               System.out.println( GXutil.trim( AV8programa)+" ["+GXutil.trim( AV14nivelDebugPalabra)+"] "+GXutil.trim( localUtil.ttoc( AV9ahoraDateTime, 8, 8, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "))+" "+AV10mensaje );
            }
         }
      }
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
   public void initialize( )
   {
      AV9ahoraDateTime = GXutil.resetTime( GXutil.nullDate() );
      GXt_dtime1 = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime2 = new java.util.Date[1] ;
      AV14nivelDebugPalabra = "" ;
      GXv_char3 = new String[1] ;
      scmdbuf = "" ;
      P029C2_A1755DebugActivo = new boolean[] {false} ;
      P029C2_A1754DebugPgm = new String[] {""} ;
      P029C2_A3CliCod = new int[1] ;
      A1754DebugPgm = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.msgdebug_prod2__default(),
         new Object[] {
             new Object[] {
            P029C2_A1755DebugActivo, P029C2_A1754DebugPgm, P029C2_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV13CliCod ;
   private int A3CliCod ;
   private String AV8programa ;
   private String AV14nivelDebugPalabra ;
   private String GXv_char3[] ;
   private String scmdbuf ;
   private java.util.Date AV9ahoraDateTime ;
   private java.util.Date GXt_dtime1 ;
   private java.util.Date GXv_dtime2[] ;
   private boolean A1755DebugActivo ;
   private String AV10mensaje ;
   private String A1754DebugPgm ;
   private IDataStoreProvider pr_default ;
   private boolean[] P029C2_A1755DebugActivo ;
   private String[] P029C2_A1754DebugPgm ;
   private int[] P029C2_A3CliCod ;
}

final  class msgdebug_prod2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P029C2", "SELECT DebugActivo, DebugPgm, CliCod FROM Debug WHERE (CliCod = ?) AND (DebugPgm = ( RTRIM(LTRIM(?)))) AND (DebugActivo = TRUE) ORDER BY CliCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
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
               stmt.setString(2, (String)parms[1], 300);
               return;
      }
   }

}

