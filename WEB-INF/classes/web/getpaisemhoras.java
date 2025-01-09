package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getpaisemhoras extends GXProcedure
{
   public getpaisemhoras( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getpaisemhoras.class ), "" );
   }

   public getpaisemhoras( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( short aP0 ,
                                           String aP1 )
   {
      getpaisemhoras.this.aP2 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( short aP0 ,
                        String aP1 ,
                        java.math.BigDecimal[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( short aP0 ,
                             String aP1 ,
                             java.math.BigDecimal[] aP2 )
   {
      getpaisemhoras.this.AV8PaiCod = aP0;
      getpaisemhoras.this.AV25parmPaiTipoTraId = aP1;
      getpaisemhoras.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01BW2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV8PaiCod), AV25parmPaiTipoTraId});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1294PaiTipoTraId = P01BW2_A1294PaiTipoTraId[0] ;
         A46PaiCod = P01BW2_A46PaiCod[0] ;
         A1337PaiTipoHsSem = P01BW2_A1337PaiTipoHsSem[0] ;
         AV13PaiTipoHsSem = A1337PaiTipoHsSem ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getpaisemhoras.this.AV13PaiTipoHsSem;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13PaiTipoHsSem = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      P01BW2_A1294PaiTipoTraId = new String[] {""} ;
      P01BW2_A46PaiCod = new short[1] ;
      P01BW2_A1337PaiTipoHsSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A1294PaiTipoTraId = "" ;
      A1337PaiTipoHsSem = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getpaisemhoras__default(),
         new Object[] {
             new Object[] {
            P01BW2_A1294PaiTipoTraId, P01BW2_A46PaiCod, P01BW2_A1337PaiTipoHsSem
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8PaiCod ;
   private short A46PaiCod ;
   private short Gx_err ;
   private java.math.BigDecimal AV13PaiTipoHsSem ;
   private java.math.BigDecimal A1337PaiTipoHsSem ;
   private String AV25parmPaiTipoTraId ;
   private String scmdbuf ;
   private String A1294PaiTipoTraId ;
   private java.math.BigDecimal[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P01BW2_A1294PaiTipoTraId ;
   private short[] P01BW2_A46PaiCod ;
   private java.math.BigDecimal[] P01BW2_A1337PaiTipoHsSem ;
}

final  class getpaisemhoras__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01BW2", "SELECT PaiTipoTraId, PaiCod, PaiTipoHsSem FROM PaisTipoTrabajo WHERE PaiCod = ? and PaiTipoTraId = ( ?) ORDER BY PaiCod, PaiTipoTraId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,1);
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
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

