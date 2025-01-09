package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getpaimaxhornor extends GXProcedure
{
   public getpaimaxhornor( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getpaimaxhornor.class ), "" );
   }

   public getpaimaxhornor( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( short aP0 )
   {
      getpaimaxhornor.this.aP1 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( short aP0 ,
                        java.math.BigDecimal[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( short aP0 ,
                             java.math.BigDecimal[] aP1 )
   {
      getpaimaxhornor.this.AV9PaiCod = aP0;
      getpaimaxhornor.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01KC2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV9PaiCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A46PaiCod = P01KC2_A46PaiCod[0] ;
         A1405PaiMaxHorNor = P01KC2_A1405PaiMaxHorNor[0] ;
         AV8PaiMaxHorNor = A1405PaiMaxHorNor ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getpaimaxhornor.this.AV8PaiMaxHorNor;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8PaiMaxHorNor = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      P01KC2_A46PaiCod = new short[1] ;
      P01KC2_A1405PaiMaxHorNor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A1405PaiMaxHorNor = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getpaimaxhornor__default(),
         new Object[] {
             new Object[] {
            P01KC2_A46PaiCod, P01KC2_A1405PaiMaxHorNor
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9PaiCod ;
   private short A46PaiCod ;
   private short Gx_err ;
   private java.math.BigDecimal AV8PaiMaxHorNor ;
   private java.math.BigDecimal A1405PaiMaxHorNor ;
   private String scmdbuf ;
   private java.math.BigDecimal[] aP1 ;
   private IDataStoreProvider pr_default ;
   private short[] P01KC2_A46PaiCod ;
   private java.math.BigDecimal[] P01KC2_A1405PaiMaxHorNor ;
}

final  class getpaimaxhornor__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01KC2", "SELECT PaiCod, PaiMaxHorNor FROM Pais WHERE PaiCod = ? ORDER BY PaiCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,1);
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

