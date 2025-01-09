package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getpaivacper extends GXProcedure
{
   public getpaivacper( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getpaivacper.class ), "" );
   }

   public getpaivacper( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( short aP0 ,
                                           byte[] aP1 ,
                                           byte[] aP2 )
   {
      getpaivacper.this.aP3 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( short aP0 ,
                        byte[] aP1 ,
                        byte[] aP2 ,
                        java.math.BigDecimal[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( short aP0 ,
                             byte[] aP1 ,
                             byte[] aP2 ,
                             java.math.BigDecimal[] aP3 )
   {
      getpaivacper.this.AV8PaiCod = aP0;
      getpaivacper.this.aP1 = aP1;
      getpaivacper.this.aP2 = aP2;
      getpaivacper.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01O52 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV8PaiCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A46PaiCod = P01O52_A46PaiCod[0] ;
         A1521PaiPerVacDes = P01O52_A1521PaiPerVacDes[0] ;
         A1522PaiPerVacHas = P01O52_A1522PaiPerVacHas[0] ;
         A1814PaiFracVacAnt = P01O52_A1814PaiFracVacAnt[0] ;
         AV10PaiPerVacDes = A1521PaiPerVacDes ;
         AV9PaiPerVacHas = A1522PaiPerVacHas ;
         AV11PaiFracVacAnt = A1814PaiFracVacAnt ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getpaivacper.this.AV10PaiPerVacDes;
      this.aP2[0] = getpaivacper.this.AV9PaiPerVacHas;
      this.aP3[0] = getpaivacper.this.AV11PaiFracVacAnt;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11PaiFracVacAnt = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      P01O52_A46PaiCod = new short[1] ;
      P01O52_A1521PaiPerVacDes = new byte[1] ;
      P01O52_A1522PaiPerVacHas = new byte[1] ;
      P01O52_A1814PaiFracVacAnt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A1814PaiFracVacAnt = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getpaivacper__default(),
         new Object[] {
             new Object[] {
            P01O52_A46PaiCod, P01O52_A1521PaiPerVacDes, P01O52_A1522PaiPerVacHas, P01O52_A1814PaiFracVacAnt
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV10PaiPerVacDes ;
   private byte AV9PaiPerVacHas ;
   private byte A1521PaiPerVacDes ;
   private byte A1522PaiPerVacHas ;
   private short AV8PaiCod ;
   private short A46PaiCod ;
   private short Gx_err ;
   private java.math.BigDecimal AV11PaiFracVacAnt ;
   private java.math.BigDecimal A1814PaiFracVacAnt ;
   private String scmdbuf ;
   private java.math.BigDecimal[] aP3 ;
   private byte[] aP1 ;
   private byte[] aP2 ;
   private IDataStoreProvider pr_default ;
   private short[] P01O52_A46PaiCod ;
   private byte[] P01O52_A1521PaiPerVacDes ;
   private byte[] P01O52_A1522PaiPerVacHas ;
   private java.math.BigDecimal[] P01O52_A1814PaiFracVacAnt ;
}

final  class getpaivacper__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01O52", "SELECT PaiCod, PaiPerVacDes, PaiPerVacHas, PaiFracVacAnt FROM Pais WHERE PaiCod = ? ORDER BY PaiCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,4);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

