package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getempdiahoras extends GXProcedure
{
   public getempdiahoras( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getempdiahoras.class ), "" );
   }

   public getempdiahoras( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           String aP2 )
   {
      getempdiahoras.this.aP3 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        java.math.BigDecimal[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             java.math.BigDecimal[] aP3 )
   {
      getempdiahoras.this.AV16CliCod = aP0;
      getempdiahoras.this.AV15EmpCod = aP1;
      getempdiahoras.this.AV18parmPaiTipoTraId = aP2;
      getempdiahoras.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01CL2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV16CliCod), Short.valueOf(AV15EmpCod), AV18parmPaiTipoTraId});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1294PaiTipoTraId = P01CL2_A1294PaiTipoTraId[0] ;
         A1EmpCod = P01CL2_A1EmpCod[0] ;
         A3CliCod = P01CL2_A3CliCod[0] ;
         A1344EmpHsDia = P01CL2_A1344EmpHsDia[0] ;
         AV20EmpHsDia = A1344EmpHsDia ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getempdiahoras.this.AV20EmpHsDia;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV20EmpHsDia = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      P01CL2_A1294PaiTipoTraId = new String[] {""} ;
      P01CL2_A1EmpCod = new short[1] ;
      P01CL2_A3CliCod = new int[1] ;
      P01CL2_A1344EmpHsDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A1294PaiTipoTraId = "" ;
      A1344EmpHsDia = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getempdiahoras__default(),
         new Object[] {
             new Object[] {
            P01CL2_A1294PaiTipoTraId, P01CL2_A1EmpCod, P01CL2_A3CliCod, P01CL2_A1344EmpHsDia
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV15EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV16CliCod ;
   private int A3CliCod ;
   private java.math.BigDecimal AV20EmpHsDia ;
   private java.math.BigDecimal A1344EmpHsDia ;
   private String AV18parmPaiTipoTraId ;
   private String scmdbuf ;
   private String A1294PaiTipoTraId ;
   private java.math.BigDecimal[] aP3 ;
   private IDataStoreProvider pr_default ;
   private String[] P01CL2_A1294PaiTipoTraId ;
   private short[] P01CL2_A1EmpCod ;
   private int[] P01CL2_A3CliCod ;
   private java.math.BigDecimal[] P01CL2_A1344EmpHsDia ;
}

final  class getempdiahoras__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01CL2", "SELECT PaiTipoTraId, EmpCod, CliCod, EmpHsDia FROM Empresatipo_trabajo WHERE CliCod = ? and EmpCod = ? and PaiTipoTraId = ( ?) ORDER BY CliCod, EmpCod, PaiTipoTraId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,1);
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
               stmt.setString(3, (String)parms[2], 20);
               return;
      }
   }

}

