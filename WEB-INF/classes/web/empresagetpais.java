package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class empresagetpais extends GXProcedure
{
   public empresagetpais( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empresagetpais.class ), "" );
   }

   public empresagetpais( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 )
   {
      empresagetpais.this.aP2 = new short[] {0};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        short[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             short[] aP2 )
   {
      empresagetpais.this.AV9clicod = aP0;
      empresagetpais.this.AV10EmpCod = aP1;
      empresagetpais.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01BZ2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9clicod), Short.valueOf(AV10EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1EmpCod = P01BZ2_A1EmpCod[0] ;
         A3CliCod = P01BZ2_A3CliCod[0] ;
         A46PaiCod = P01BZ2_A46PaiCod[0] ;
         n46PaiCod = P01BZ2_n46PaiCod[0] ;
         AV11PaiCod = A46PaiCod ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      new web.pruebaharcode(remoteHandle, context).execute( ) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = empresagetpais.this.AV11PaiCod;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      P01BZ2_A1EmpCod = new short[1] ;
      P01BZ2_A3CliCod = new int[1] ;
      P01BZ2_A46PaiCod = new short[1] ;
      P01BZ2_n46PaiCod = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empresagetpais__default(),
         new Object[] {
             new Object[] {
            P01BZ2_A1EmpCod, P01BZ2_A3CliCod, P01BZ2_A46PaiCod, P01BZ2_n46PaiCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short AV11PaiCod ;
   private short A1EmpCod ;
   private short A46PaiCod ;
   private short Gx_err ;
   private int AV9clicod ;
   private int A3CliCod ;
   private String scmdbuf ;
   private boolean n46PaiCod ;
   private short[] aP2 ;
   private IDataStoreProvider pr_default ;
   private short[] P01BZ2_A1EmpCod ;
   private int[] P01BZ2_A3CliCod ;
   private short[] P01BZ2_A46PaiCod ;
   private boolean[] P01BZ2_n46PaiCod ;
}

final  class empresagetpais__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01BZ2", "SELECT EmpCod, CliCod, PaiCod FROM Empresa WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
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
               return;
      }
   }

}

