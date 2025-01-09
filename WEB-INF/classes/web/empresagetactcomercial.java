package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class empresagetactcomercial extends GXProcedure
{
   public empresagetactcomercial( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empresagetactcomercial.class ), "" );
   }

   public empresagetactcomercial( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 )
   {
      empresagetactcomercial.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String[] aP2 )
   {
      empresagetactcomercial.this.AV10CliCod = aP0;
      empresagetactcomercial.this.AV9EmpCod = aP1;
      empresagetactcomercial.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00Y72 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV9EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1EmpCod = P00Y72_A1EmpCod[0] ;
         A3CliCod = P00Y72_A3CliCod[0] ;
         A1533EmpActComercial = P00Y72_A1533EmpActComercial[0] ;
         AV8ActComCodigo = A1533EmpActComercial ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = empresagetactcomercial.this.AV8ActComCodigo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8ActComCodigo = "" ;
      scmdbuf = "" ;
      P00Y72_A1EmpCod = new short[1] ;
      P00Y72_A3CliCod = new int[1] ;
      P00Y72_A1533EmpActComercial = new String[] {""} ;
      A1533EmpActComercial = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empresagetactcomercial__default(),
         new Object[] {
             new Object[] {
            P00Y72_A1EmpCod, P00Y72_A3CliCod, P00Y72_A1533EmpActComercial
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
   private int A3CliCod ;
   private String AV8ActComCodigo ;
   private String scmdbuf ;
   private String A1533EmpActComercial ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private short[] P00Y72_A1EmpCod ;
   private int[] P00Y72_A3CliCod ;
   private String[] P00Y72_A1533EmpActComercial ;
}

final  class empresagetactcomercial__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00Y72", "SELECT EmpCod, CliCod, EmpActComercial FROM Empresa WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
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

