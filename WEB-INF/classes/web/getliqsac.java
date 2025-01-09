package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getliqsac extends GXProcedure
{
   public getliqsac( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getliqsac.class ), "" );
   }

   public getliqsac( int remoteHandle ,
                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             boolean[] aP3 )
   {
      getliqsac.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        boolean[] aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             boolean[] aP3 ,
                             String[] aP4 )
   {
      getliqsac.this.AV10CliCod = aP0;
      getliqsac.this.AV9EmpCod = aP1;
      getliqsac.this.AV11liqnro = aP2;
      getliqsac.this.aP3 = aP3;
      getliqsac.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02702 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV11liqnro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A31LiqNro = P02702_A31LiqNro[0] ;
         A1EmpCod = P02702_A1EmpCod[0] ;
         A3CliCod = P02702_A3CliCod[0] ;
         A2195LiqSac = P02702_A2195LiqSac[0] ;
         n2195LiqSac = P02702_n2195LiqSac[0] ;
         A2196LiqSacLog = P02702_A2196LiqSacLog[0] ;
         n2196LiqSacLog = P02702_n2196LiqSacLog[0] ;
         AV8LiqSac = A2195LiqSac ;
         AV12LiqSacLog = A2196LiqSacLog ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getliqsac.this.AV8LiqSac;
      this.aP4[0] = getliqsac.this.AV12LiqSacLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12LiqSacLog = "" ;
      scmdbuf = "" ;
      P02702_A31LiqNro = new int[1] ;
      P02702_A1EmpCod = new short[1] ;
      P02702_A3CliCod = new int[1] ;
      P02702_A2195LiqSac = new boolean[] {false} ;
      P02702_n2195LiqSac = new boolean[] {false} ;
      P02702_A2196LiqSacLog = new String[] {""} ;
      P02702_n2196LiqSacLog = new boolean[] {false} ;
      A2196LiqSacLog = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getliqsac__default(),
         new Object[] {
             new Object[] {
            P02702_A31LiqNro, P02702_A1EmpCod, P02702_A3CliCod, P02702_A2195LiqSac, P02702_n2195LiqSac, P02702_A2196LiqSacLog, P02702_n2196LiqSacLog
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV11liqnro ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private String scmdbuf ;
   private boolean AV8LiqSac ;
   private boolean A2195LiqSac ;
   private boolean n2195LiqSac ;
   private boolean n2196LiqSacLog ;
   private String AV12LiqSacLog ;
   private String A2196LiqSacLog ;
   private String[] aP4 ;
   private boolean[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P02702_A31LiqNro ;
   private short[] P02702_A1EmpCod ;
   private int[] P02702_A3CliCod ;
   private boolean[] P02702_A2195LiqSac ;
   private boolean[] P02702_n2195LiqSac ;
   private String[] P02702_A2196LiqSacLog ;
   private boolean[] P02702_n2196LiqSacLog ;
}

final  class getliqsac__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02702", "SELECT LiqNro, EmpCod, CliCod, LiqSac, LiqSacLog FROM Liquidacion WHERE CliCod = ? and EmpCod = ? and LiqNro = ? ORDER BY CliCod, EmpCod, LiqNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
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
               return;
      }
   }

}

