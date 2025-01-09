package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getliqestpdf extends GXProcedure
{
   public getliqestpdf( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getliqestpdf.class ), "" );
   }

   public getliqestpdf( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 )
   {
      getliqestpdf.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String[] aP3 )
   {
      getliqestpdf.this.AV8CliCod = aP0;
      getliqestpdf.this.AV9EmpCod = aP1;
      getliqestpdf.this.AV10LiqNro = aP2;
      getliqestpdf.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02IL2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LiqNro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A31LiqNro = P02IL2_A31LiqNro[0] ;
         A1EmpCod = P02IL2_A1EmpCod[0] ;
         A3CliCod = P02IL2_A3CliCod[0] ;
         A2180LiqPDFEstado = P02IL2_A2180LiqPDFEstado[0] ;
         n2180LiqPDFEstado = P02IL2_n2180LiqPDFEstado[0] ;
         AV11LiqPDFEstado = A2180LiqPDFEstado ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getliqestpdf.this.AV11LiqPDFEstado;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11LiqPDFEstado = "" ;
      scmdbuf = "" ;
      P02IL2_A31LiqNro = new int[1] ;
      P02IL2_A1EmpCod = new short[1] ;
      P02IL2_A3CliCod = new int[1] ;
      P02IL2_A2180LiqPDFEstado = new String[] {""} ;
      P02IL2_n2180LiqPDFEstado = new boolean[] {false} ;
      A2180LiqPDFEstado = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getliqestpdf__default(),
         new Object[] {
             new Object[] {
            P02IL2_A31LiqNro, P02IL2_A1EmpCod, P02IL2_A3CliCod, P02IL2_A2180LiqPDFEstado, P02IL2_n2180LiqPDFEstado
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10LiqNro ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private String AV11LiqPDFEstado ;
   private String scmdbuf ;
   private String A2180LiqPDFEstado ;
   private boolean n2180LiqPDFEstado ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P02IL2_A31LiqNro ;
   private short[] P02IL2_A1EmpCod ;
   private int[] P02IL2_A3CliCod ;
   private String[] P02IL2_A2180LiqPDFEstado ;
   private boolean[] P02IL2_n2180LiqPDFEstado ;
}

final  class getliqestpdf__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02IL2", "SELECT LiqNro, EmpCod, CliCod, LiqPDFEstado FROM Liquidacion WHERE CliCod = ? and EmpCod = ? and LiqNro = ? ORDER BY CliCod, EmpCod, LiqNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
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

