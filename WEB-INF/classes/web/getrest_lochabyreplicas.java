package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getrest_lochabyreplicas extends GXProcedure
{
   public getrest_lochabyreplicas( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getrest_lochabyreplicas.class ), "" );
   }

   public getrest_lochabyreplicas( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXSimpleCollection<Short> executeUdp( int aP0 ,
                                                String aP1 ,
                                                boolean[] aP2 )
   {
      getrest_lochabyreplicas.this.aP3 = new GXSimpleCollection[] {new GXSimpleCollection<Short>(Short.class, "internal", "")};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        boolean[] aP2 ,
                        GXSimpleCollection<Short>[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             boolean[] aP2 ,
                             GXSimpleCollection<Short>[] aP3 )
   {
      getrest_lochabyreplicas.this.AV8CliCod = aP0;
      getrest_lochabyreplicas.this.AV9RestLocId = aP1;
      getrest_lochabyreplicas.this.aP2 = aP2;
      getrest_lochabyreplicas.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV20Pgmname, httpContext.getMessage( "&CliCod ", "")+GXutil.trim( GXutil.str( AV8CliCod, 6, 0))+httpContext.getMessage( " &RestLocId \"", "")+AV9RestLocId+"\"") ;
      AV21GXLvl2 = (byte)(0) ;
      /* Using cursor P02J72 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV9RestLocId});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2171RestLocId = P02J72_A2171RestLocId[0] ;
         A3CliCod = P02J72_A3CliCod[0] ;
         A2172RestLocHab = P02J72_A2172RestLocHab[0] ;
         A2173RestLocBaseUrl = P02J72_A2173RestLocBaseUrl[0] ;
         A2174RestLocCancelOnError = P02J72_A2174RestLocCancelOnError[0] ;
         A2175RestLocHost = P02J72_A2175RestLocHost[0] ;
         A2176RestLocPort = P02J72_A2176RestLocPort[0] ;
         A2177RestLocTimeout = P02J72_A2177RestLocTimeout[0] ;
         A2178RestLocSecure = P02J72_A2178RestLocSecure[0] ;
         AV21GXLvl2 = (byte)(1) ;
         AV10RestLocHab = A2172RestLocHab ;
         AV11RestLocBaseUrl = A2173RestLocBaseUrl ;
         AV12RestLocCancelOnError = A2174RestLocCancelOnError ;
         AV13RestLocHost = A2175RestLocHost ;
         AV14RestLocPort = A2176RestLocPort ;
         AV15RestLocTimeout = A2177RestLocTimeout ;
         AV16RestLocSecure = A2178RestLocSecure ;
         /* Using cursor P02J73 */
         pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), A2171RestLocId});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A2334RestLocRHab = P02J73_A2334RestLocRHab[0] ;
            A2333RestLocRNro = P02J73_A2333RestLocRNro[0] ;
            AV17RestLocRNro.add((short)(A2333RestLocRNro), 0);
            pr_default.readNext(1);
         }
         pr_default.close(1);
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV21GXLvl2 == 0 )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV20Pgmname, httpContext.getMessage( "none", "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getrest_lochabyreplicas.this.AV10RestLocHab;
      this.aP3[0] = getrest_lochabyreplicas.this.AV17RestLocRNro;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV17RestLocRNro = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV20Pgmname = "" ;
      scmdbuf = "" ;
      P02J72_A2171RestLocId = new String[] {""} ;
      P02J72_A3CliCod = new int[1] ;
      P02J72_A2172RestLocHab = new boolean[] {false} ;
      P02J72_A2173RestLocBaseUrl = new String[] {""} ;
      P02J72_A2174RestLocCancelOnError = new byte[1] ;
      P02J72_A2175RestLocHost = new String[] {""} ;
      P02J72_A2176RestLocPort = new int[1] ;
      P02J72_A2177RestLocTimeout = new short[1] ;
      P02J72_A2178RestLocSecure = new byte[1] ;
      A2171RestLocId = "" ;
      A2173RestLocBaseUrl = "" ;
      A2175RestLocHost = "" ;
      AV11RestLocBaseUrl = "" ;
      AV13RestLocHost = "" ;
      P02J73_A3CliCod = new int[1] ;
      P02J73_A2171RestLocId = new String[] {""} ;
      P02J73_A2334RestLocRHab = new boolean[] {false} ;
      P02J73_A2333RestLocRNro = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getrest_lochabyreplicas__default(),
         new Object[] {
             new Object[] {
            P02J72_A2171RestLocId, P02J72_A3CliCod, P02J72_A2172RestLocHab, P02J72_A2173RestLocBaseUrl, P02J72_A2174RestLocCancelOnError, P02J72_A2175RestLocHost, P02J72_A2176RestLocPort, P02J72_A2177RestLocTimeout, P02J72_A2178RestLocSecure
            }
            , new Object[] {
            P02J73_A3CliCod, P02J73_A2171RestLocId, P02J73_A2334RestLocRHab, P02J73_A2333RestLocRNro
            }
         }
      );
      AV20Pgmname = "getRest_LocHabYReplicas" ;
      /* GeneXus formulas. */
      AV20Pgmname = "getRest_LocHabYReplicas" ;
      Gx_err = (short)(0) ;
   }

   private byte AV21GXLvl2 ;
   private byte A2174RestLocCancelOnError ;
   private byte A2178RestLocSecure ;
   private byte AV12RestLocCancelOnError ;
   private byte AV16RestLocSecure ;
   private short A2177RestLocTimeout ;
   private short AV15RestLocTimeout ;
   private short A2333RestLocRNro ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private int A2176RestLocPort ;
   private int AV14RestLocPort ;
   private String AV9RestLocId ;
   private String AV20Pgmname ;
   private String scmdbuf ;
   private String A2171RestLocId ;
   private boolean AV10RestLocHab ;
   private boolean A2172RestLocHab ;
   private boolean A2334RestLocRHab ;
   private String A2173RestLocBaseUrl ;
   private String A2175RestLocHost ;
   private String AV11RestLocBaseUrl ;
   private String AV13RestLocHost ;
   private GXSimpleCollection<Short> AV17RestLocRNro ;
   private GXSimpleCollection<Short>[] aP3 ;
   private boolean[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P02J72_A2171RestLocId ;
   private int[] P02J72_A3CliCod ;
   private boolean[] P02J72_A2172RestLocHab ;
   private String[] P02J72_A2173RestLocBaseUrl ;
   private byte[] P02J72_A2174RestLocCancelOnError ;
   private String[] P02J72_A2175RestLocHost ;
   private int[] P02J72_A2176RestLocPort ;
   private short[] P02J72_A2177RestLocTimeout ;
   private byte[] P02J72_A2178RestLocSecure ;
   private int[] P02J73_A3CliCod ;
   private String[] P02J73_A2171RestLocId ;
   private boolean[] P02J73_A2334RestLocRHab ;
   private short[] P02J73_A2333RestLocRNro ;
}

final  class getrest_lochabyreplicas__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02J72", "SELECT RestLocId, CliCod, RestLocHab, RestLocBaseUrl, RestLocCancelOnError, RestLocHost, RestLocPort, RestLocTimeout, RestLocSecure FROM rest_location WHERE CliCod = ? and RestLocId = ( ?) ORDER BY CliCod, RestLocId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P02J73", "SELECT CliCod, RestLocId, RestLocRHab, RestLocRNro FROM rest_locationreplicas WHERE (CliCod = ? and RestLocId = ( ?)) AND (RestLocRHab = TRUE) ORDER BY CliCod, RestLocId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
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
               return;
      }
   }

}

