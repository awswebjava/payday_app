package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getempresavizzoti extends GXProcedure
{
   public getempresavizzoti( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getempresavizzoti.class ), "" );
   }

   public getempresavizzoti( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           boolean[] aP2 )
   {
      getempresavizzoti.this.aP3 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        boolean[] aP2 ,
                        java.math.BigDecimal[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             boolean[] aP2 ,
                             java.math.BigDecimal[] aP3 )
   {
      getempresavizzoti.this.AV9CliCod = aP0;
      getempresavizzoti.this.AV8EmpCod = aP1;
      getempresavizzoti.this.aP2 = aP2;
      getempresavizzoti.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_int1[0] = AV13PaiCod ;
      new web.clientegetpais(remoteHandle, context).execute( AV9CliCod, GXv_int1) ;
      getempresavizzoti.this.AV13PaiCod = GXv_int1[0] ;
      /* Using cursor P01F22 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV13PaiCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A46PaiCod = P01F22_A46PaiCod[0] ;
         A1736PaiExcVizzoti = P01F22_A1736PaiExcVizzoti[0] ;
         A1737PaiVizzoti = P01F22_A1737PaiVizzoti[0] ;
         AV14PaiExcVizzoti = A1736PaiExcVizzoti ;
         AV15PaiVizzoti = A1737PaiVizzoti ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getempresavizzoti.this.AV14PaiExcVizzoti;
      this.aP3[0] = getempresavizzoti.this.AV15PaiVizzoti;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV15PaiVizzoti = DecimalUtil.ZERO ;
      GXv_int1 = new short[1] ;
      scmdbuf = "" ;
      P01F22_A46PaiCod = new short[1] ;
      P01F22_A1736PaiExcVizzoti = new boolean[] {false} ;
      P01F22_A1737PaiVizzoti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A1737PaiVizzoti = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getempresavizzoti__default(),
         new Object[] {
             new Object[] {
            P01F22_A46PaiCod, P01F22_A1736PaiExcVizzoti, P01F22_A1737PaiVizzoti
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8EmpCod ;
   private short AV13PaiCod ;
   private short GXv_int1[] ;
   private short A46PaiCod ;
   private short Gx_err ;
   private int AV9CliCod ;
   private java.math.BigDecimal AV15PaiVizzoti ;
   private java.math.BigDecimal A1737PaiVizzoti ;
   private String scmdbuf ;
   private boolean AV14PaiExcVizzoti ;
   private boolean A1736PaiExcVizzoti ;
   private java.math.BigDecimal[] aP3 ;
   private boolean[] aP2 ;
   private IDataStoreProvider pr_default ;
   private short[] P01F22_A46PaiCod ;
   private boolean[] P01F22_A1736PaiExcVizzoti ;
   private java.math.BigDecimal[] P01F22_A1737PaiVizzoti ;
}

final  class getempresavizzoti__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01F22", "SELECT PaiCod, PaiExcVizzoti, PaiVizzoti FROM Pais WHERE PaiCod = ? ORDER BY PaiCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,4);
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

