package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getrest_lochostport extends GXProcedure
{
   public getrest_lochostport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getrest_lochostport.class ), "" );
   }

   public getrest_lochostport( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public int executeUdp( int aP0 ,
                          String aP1 ,
                          short aP2 ,
                          boolean[] aP3 ,
                          String[] aP4 )
   {
      getrest_lochostport.this.aP5 = new int[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        short aP2 ,
                        boolean[] aP3 ,
                        String[] aP4 ,
                        int[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             short aP2 ,
                             boolean[] aP3 ,
                             String[] aP4 ,
                             int[] aP5 )
   {
      getrest_lochostport.this.AV12CliCod = aP0;
      getrest_lochostport.this.AV10RestLocId = aP1;
      getrest_lochostport.this.AV13RestLocRNro = aP2;
      getrest_lochostport.this.aP3 = aP3;
      getrest_lochostport.this.aP4 = aP4;
      getrest_lochostport.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV17Pgmname, httpContext.getMessage( "&CliCod ", "")+GXutil.trim( GXutil.str( AV12CliCod, 6, 0))+httpContext.getMessage( " &RestLocId \"", "")+AV10RestLocId+"\"") ;
      AV18GXLvl2 = (byte)(0) ;
      /* Using cursor P02IK2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliCod), AV10RestLocId});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2171RestLocId = P02IK2_A2171RestLocId[0] ;
         A3CliCod = P02IK2_A3CliCod[0] ;
         A2172RestLocHab = P02IK2_A2172RestLocHab[0] ;
         A2175RestLocHost = P02IK2_A2175RestLocHost[0] ;
         A2176RestLocPort = P02IK2_A2176RestLocPort[0] ;
         AV18GXLvl2 = (byte)(1) ;
         if ( (0==AV13RestLocRNro) )
         {
            AV8RestLocHab = A2172RestLocHab ;
            AV9RestLocHost = A2175RestLocHost ;
            AV11RestLocPort = A2176RestLocPort ;
         }
         else
         {
            /* Using cursor P02IK3 */
            pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), A2171RestLocId, Short.valueOf(AV13RestLocRNro)});
            while ( (pr_default.getStatus(1) != 101) )
            {
               A2333RestLocRNro = P02IK3_A2333RestLocRNro[0] ;
               A2334RestLocRHab = P02IK3_A2334RestLocRHab[0] ;
               A2337RestLocRHost = P02IK3_A2337RestLocRHost[0] ;
               A2338RestLocRPort = P02IK3_A2338RestLocRPort[0] ;
               AV8RestLocHab = A2334RestLocRHab ;
               AV9RestLocHost = A2337RestLocRHost ;
               AV11RestLocPort = A2338RestLocRPort ;
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
         new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV17Pgmname, httpContext.getMessage( "none", "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getrest_lochostport.this.AV8RestLocHab;
      this.aP4[0] = getrest_lochostport.this.AV9RestLocHost;
      this.aP5[0] = getrest_lochostport.this.AV11RestLocPort;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9RestLocHost = "" ;
      AV17Pgmname = "" ;
      scmdbuf = "" ;
      P02IK2_A2171RestLocId = new String[] {""} ;
      P02IK2_A3CliCod = new int[1] ;
      P02IK2_A2172RestLocHab = new boolean[] {false} ;
      P02IK2_A2175RestLocHost = new String[] {""} ;
      P02IK2_A2176RestLocPort = new int[1] ;
      A2171RestLocId = "" ;
      A2175RestLocHost = "" ;
      P02IK3_A3CliCod = new int[1] ;
      P02IK3_A2171RestLocId = new String[] {""} ;
      P02IK3_A2333RestLocRNro = new short[1] ;
      P02IK3_A2334RestLocRHab = new boolean[] {false} ;
      P02IK3_A2337RestLocRHost = new String[] {""} ;
      P02IK3_A2338RestLocRPort = new int[1] ;
      A2337RestLocRHost = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getrest_lochostport__default(),
         new Object[] {
             new Object[] {
            P02IK2_A2171RestLocId, P02IK2_A3CliCod, P02IK2_A2172RestLocHab, P02IK2_A2175RestLocHost, P02IK2_A2176RestLocPort
            }
            , new Object[] {
            P02IK3_A3CliCod, P02IK3_A2171RestLocId, P02IK3_A2333RestLocRNro, P02IK3_A2334RestLocRHab, P02IK3_A2337RestLocRHost, P02IK3_A2338RestLocRPort
            }
         }
      );
      AV17Pgmname = "getRest_LocHostPort" ;
      /* GeneXus formulas. */
      AV17Pgmname = "getRest_LocHostPort" ;
      Gx_err = (short)(0) ;
   }

   private byte AV18GXLvl2 ;
   private short AV13RestLocRNro ;
   private short A2333RestLocRNro ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV11RestLocPort ;
   private int A3CliCod ;
   private int A2176RestLocPort ;
   private int A2338RestLocRPort ;
   private String AV10RestLocId ;
   private String AV17Pgmname ;
   private String scmdbuf ;
   private String A2171RestLocId ;
   private boolean AV8RestLocHab ;
   private boolean A2172RestLocHab ;
   private boolean A2334RestLocRHab ;
   private String AV9RestLocHost ;
   private String A2175RestLocHost ;
   private String A2337RestLocRHost ;
   private int[] aP5 ;
   private boolean[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P02IK2_A2171RestLocId ;
   private int[] P02IK2_A3CliCod ;
   private boolean[] P02IK2_A2172RestLocHab ;
   private String[] P02IK2_A2175RestLocHost ;
   private int[] P02IK2_A2176RestLocPort ;
   private int[] P02IK3_A3CliCod ;
   private String[] P02IK3_A2171RestLocId ;
   private short[] P02IK3_A2333RestLocRNro ;
   private boolean[] P02IK3_A2334RestLocRHab ;
   private String[] P02IK3_A2337RestLocRHost ;
   private int[] P02IK3_A2338RestLocRPort ;
}

final  class getrest_lochostport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02IK2", "SELECT RestLocId, CliCod, RestLocHab, RestLocHost, RestLocPort FROM rest_location WHERE CliCod = ? and RestLocId = ( ?) ORDER BY CliCod, RestLocId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P02IK3", "SELECT CliCod, RestLocId, RestLocRNro, RestLocRHab, RestLocRHost, RestLocRPort FROM rest_locationreplicas WHERE CliCod = ? and RestLocId = ( ?) and RestLocRNro = ? ORDER BY CliCod, RestLocId, RestLocRNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[4])[0] = rslt.getInt(5);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
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

