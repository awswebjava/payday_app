package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getemppervac extends GXProcedure
{
   public getemppervac( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getemppervac.class ), "" );
   }

   public getemppervac( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           byte[] aP2 ,
                                           byte[] aP3 )
   {
      getemppervac.this.aP4 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        byte[] aP2 ,
                        byte[] aP3 ,
                        java.math.BigDecimal[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             byte[] aP2 ,
                             byte[] aP3 ,
                             java.math.BigDecimal[] aP4 )
   {
      getemppervac.this.AV8CliCod = aP0;
      getemppervac.this.AV11EmpCod = aP1;
      getemppervac.this.aP2 = aP2;
      getemppervac.this.aP3 = aP3;
      getemppervac.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01OM2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV11EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1EmpCod = P01OM2_A1EmpCod[0] ;
         A3CliCod = P01OM2_A3CliCod[0] ;
         A1811EmpPerVacDes = P01OM2_A1811EmpPerVacDes[0] ;
         A1812EmpPerVacHas = P01OM2_A1812EmpPerVacHas[0] ;
         A1813EmpFracVacAnt = P01OM2_A1813EmpFracVacAnt[0] ;
         AV9EmpPerVacDes = A1811EmpPerVacDes ;
         AV10EmpPerVacHas = A1812EmpPerVacHas ;
         AV12EmpFracVacAnt = A1813EmpFracVacAnt ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getemppervac.this.AV9EmpPerVacDes;
      this.aP3[0] = getemppervac.this.AV10EmpPerVacHas;
      this.aP4[0] = getemppervac.this.AV12EmpFracVacAnt;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12EmpFracVacAnt = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      P01OM2_A1EmpCod = new short[1] ;
      P01OM2_A3CliCod = new int[1] ;
      P01OM2_A1811EmpPerVacDes = new byte[1] ;
      P01OM2_A1812EmpPerVacHas = new byte[1] ;
      P01OM2_A1813EmpFracVacAnt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A1813EmpFracVacAnt = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getemppervac__default(),
         new Object[] {
             new Object[] {
            P01OM2_A1EmpCod, P01OM2_A3CliCod, P01OM2_A1811EmpPerVacDes, P01OM2_A1812EmpPerVacHas, P01OM2_A1813EmpFracVacAnt
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV9EmpPerVacDes ;
   private byte AV10EmpPerVacHas ;
   private byte A1811EmpPerVacDes ;
   private byte A1812EmpPerVacHas ;
   private short AV11EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private java.math.BigDecimal AV12EmpFracVacAnt ;
   private java.math.BigDecimal A1813EmpFracVacAnt ;
   private String scmdbuf ;
   private java.math.BigDecimal[] aP4 ;
   private byte[] aP2 ;
   private byte[] aP3 ;
   private IDataStoreProvider pr_default ;
   private short[] P01OM2_A1EmpCod ;
   private int[] P01OM2_A3CliCod ;
   private byte[] P01OM2_A1811EmpPerVacDes ;
   private byte[] P01OM2_A1812EmpPerVacHas ;
   private java.math.BigDecimal[] P01OM2_A1813EmpFracVacAnt ;
}

final  class getemppervac__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01OM2", "SELECT EmpCod, CliCod, EmpPerVacDes, EmpPerVacHas, EmpFracVacAnt FROM Empresa WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
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

