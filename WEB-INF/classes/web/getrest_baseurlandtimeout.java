package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getrest_baseurlandtimeout extends GXProcedure
{
   public getrest_baseurlandtimeout( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getrest_baseurlandtimeout.class ), "" );
   }

   public getrest_baseurlandtimeout( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            String aP1 ,
                            short aP2 ,
                            boolean[] aP3 ,
                            String[] aP4 )
   {
      getrest_baseurlandtimeout.this.aP5 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        short aP2 ,
                        boolean[] aP3 ,
                        String[] aP4 ,
                        short[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             short aP2 ,
                             boolean[] aP3 ,
                             String[] aP4 ,
                             short[] aP5 )
   {
      getrest_baseurlandtimeout.this.AV10CliCod = aP0;
      getrest_baseurlandtimeout.this.AV9RestLocId = aP1;
      getrest_baseurlandtimeout.this.AV12RestLocRNro = aP2;
      getrest_baseurlandtimeout.this.aP3 = aP3;
      getrest_baseurlandtimeout.this.aP4 = aP4;
      getrest_baseurlandtimeout.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV17Pgmname, httpContext.getMessage( "&CliCod ", "")+GXutil.trim( GXutil.str( AV10CliCod, 6, 0))+httpContext.getMessage( " &RestLocId \"", "")+AV9RestLocId+"\"") ;
      AV18GXLvl2 = (byte)(0) ;
      /* Using cursor P02IP2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), AV9RestLocId});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2171RestLocId = P02IP2_A2171RestLocId[0] ;
         A3CliCod = P02IP2_A3CliCod[0] ;
         A2172RestLocHab = P02IP2_A2172RestLocHab[0] ;
         A2173RestLocBaseUrl = P02IP2_A2173RestLocBaseUrl[0] ;
         A2177RestLocTimeout = P02IP2_A2177RestLocTimeout[0] ;
         AV18GXLvl2 = (byte)(1) ;
         if ( (0==AV12RestLocRNro) )
         {
            AV8RestLocHab = A2172RestLocHab ;
            AV11RestLocBaseUrl = A2173RestLocBaseUrl ;
            AV14RestLocTimeout = A2177RestLocTimeout ;
         }
         else
         {
            /* Using cursor P02IP3 */
            pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), A2171RestLocId, Short.valueOf(AV12RestLocRNro)});
            while ( (pr_default.getStatus(1) != 101) )
            {
               A2333RestLocRNro = P02IP3_A2333RestLocRNro[0] ;
               A2334RestLocRHab = P02IP3_A2334RestLocRHab[0] ;
               A2335RestLocRBaseUrl = P02IP3_A2335RestLocRBaseUrl[0] ;
               A2339RestLocRTimeout = P02IP3_A2339RestLocRTimeout[0] ;
               AV8RestLocHab = A2334RestLocRHab ;
               AV11RestLocBaseUrl = A2335RestLocRBaseUrl ;
               AV14RestLocTimeout = A2339RestLocRTimeout ;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(1);
         }
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV18GXLvl2 == 0 )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV17Pgmname, httpContext.getMessage( "none", "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getrest_baseurlandtimeout.this.AV8RestLocHab;
      this.aP4[0] = getrest_baseurlandtimeout.this.AV11RestLocBaseUrl;
      this.aP5[0] = getrest_baseurlandtimeout.this.AV14RestLocTimeout;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11RestLocBaseUrl = "" ;
      AV17Pgmname = "" ;
      scmdbuf = "" ;
      P02IP2_A2171RestLocId = new String[] {""} ;
      P02IP2_A3CliCod = new int[1] ;
      P02IP2_A2172RestLocHab = new boolean[] {false} ;
      P02IP2_A2173RestLocBaseUrl = new String[] {""} ;
      P02IP2_A2177RestLocTimeout = new short[1] ;
      A2171RestLocId = "" ;
      A2173RestLocBaseUrl = "" ;
      P02IP3_A3CliCod = new int[1] ;
      P02IP3_A2171RestLocId = new String[] {""} ;
      P02IP3_A2333RestLocRNro = new short[1] ;
      P02IP3_A2334RestLocRHab = new boolean[] {false} ;
      P02IP3_A2335RestLocRBaseUrl = new String[] {""} ;
      P02IP3_A2339RestLocRTimeout = new short[1] ;
      A2335RestLocRBaseUrl = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getrest_baseurlandtimeout__default(),
         new Object[] {
             new Object[] {
            P02IP2_A2171RestLocId, P02IP2_A3CliCod, P02IP2_A2172RestLocHab, P02IP2_A2173RestLocBaseUrl, P02IP2_A2177RestLocTimeout
            }
            , new Object[] {
            P02IP3_A3CliCod, P02IP3_A2171RestLocId, P02IP3_A2333RestLocRNro, P02IP3_A2334RestLocRHab, P02IP3_A2335RestLocRBaseUrl, P02IP3_A2339RestLocRTimeout
            }
         }
      );
      AV17Pgmname = "getRest_BaseURLAndTimeOut" ;
      /* GeneXus formulas. */
      AV17Pgmname = "getRest_BaseURLAndTimeOut" ;
      Gx_err = (short)(0) ;
   }

   private byte AV18GXLvl2 ;
   private short AV12RestLocRNro ;
   private short AV14RestLocTimeout ;
   private short A2177RestLocTimeout ;
   private short A2333RestLocRNro ;
   private short A2339RestLocRTimeout ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int A3CliCod ;
   private String AV9RestLocId ;
   private String AV17Pgmname ;
   private String scmdbuf ;
   private String A2171RestLocId ;
   private boolean AV8RestLocHab ;
   private boolean A2172RestLocHab ;
   private boolean A2334RestLocRHab ;
   private String AV11RestLocBaseUrl ;
   private String A2173RestLocBaseUrl ;
   private String A2335RestLocRBaseUrl ;
   private short[] aP5 ;
   private boolean[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P02IP2_A2171RestLocId ;
   private int[] P02IP2_A3CliCod ;
   private boolean[] P02IP2_A2172RestLocHab ;
   private String[] P02IP2_A2173RestLocBaseUrl ;
   private short[] P02IP2_A2177RestLocTimeout ;
   private int[] P02IP3_A3CliCod ;
   private String[] P02IP3_A2171RestLocId ;
   private short[] P02IP3_A2333RestLocRNro ;
   private boolean[] P02IP3_A2334RestLocRHab ;
   private String[] P02IP3_A2335RestLocRBaseUrl ;
   private short[] P02IP3_A2339RestLocRTimeout ;
}

final  class getrest_baseurlandtimeout__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02IP2", "SELECT RestLocId, CliCod, RestLocHab, RestLocBaseUrl, RestLocTimeout FROM rest_location WHERE CliCod = ? and RestLocId = ( ?) ORDER BY CliCod, RestLocId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P02IP3", "SELECT CliCod, RestLocId, RestLocRNro, RestLocRHab, RestLocRBaseUrl, RestLocRTimeout FROM rest_locationreplicas WHERE CliCod = ? and RestLocId = ( ?) and RestLocRNro = ? ORDER BY CliCod, RestLocId, RestLocRNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
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
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
      }
   }

}

