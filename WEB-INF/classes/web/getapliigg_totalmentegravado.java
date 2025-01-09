package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getapliigg_totalmentegravado extends GXProcedure
{
   public getapliigg_totalmentegravado( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getapliigg_totalmentegravado.class ), "" );
   }

   public getapliigg_totalmentegravado( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 )
   {
      getapliigg_totalmentegravado.this.aP1 = new short[] {0};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        short[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             short[] aP1 )
   {
      getapliigg_totalmentegravado.this.AV9CliCod = aP0;
      getapliigg_totalmentegravado.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P017C2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Byte.valueOf(AV10AplIIGGTrat)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1119AplIIGGTopeFij = P017C2_A1119AplIIGGTopeFij[0] ;
         A1114AplIIGGPropor = P017C2_A1114AplIIGGPropor[0] ;
         A1115AplIIGGTopeTip = P017C2_A1115AplIIGGTopeTip[0] ;
         A1120AplIIGGTrat = P017C2_A1120AplIIGGTrat[0] ;
         A3CliCod = P017C2_A3CliCod[0] ;
         A1112AplIIGG = P017C2_A1112AplIIGG[0] ;
         AV15AplIIGG = A1112AplIIGG ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getapliigg_totalmentegravado.this.AV15AplIIGG;
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
      P017C2_A1119AplIIGGTopeFij = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P017C2_A1114AplIIGGPropor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P017C2_A1115AplIIGGTopeTip = new byte[1] ;
      P017C2_A1120AplIIGGTrat = new byte[1] ;
      P017C2_A3CliCod = new int[1] ;
      P017C2_A1112AplIIGG = new short[1] ;
      A1119AplIIGGTopeFij = DecimalUtil.ZERO ;
      A1114AplIIGGPropor = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getapliigg_totalmentegravado__default(),
         new Object[] {
             new Object[] {
            P017C2_A1119AplIIGGTopeFij, P017C2_A1114AplIIGGPropor, P017C2_A1115AplIIGGTopeTip, P017C2_A1120AplIIGGTrat, P017C2_A3CliCod, P017C2_A1112AplIIGG
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV10AplIIGGTrat ;
   private byte A1115AplIIGGTopeTip ;
   private byte A1120AplIIGGTrat ;
   private short AV15AplIIGG ;
   private short A1112AplIIGG ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int A3CliCod ;
   private java.math.BigDecimal A1119AplIIGGTopeFij ;
   private java.math.BigDecimal A1114AplIIGGPropor ;
   private String scmdbuf ;
   private short[] aP1 ;
   private IDataStoreProvider pr_default ;
   private java.math.BigDecimal[] P017C2_A1119AplIIGGTopeFij ;
   private java.math.BigDecimal[] P017C2_A1114AplIIGGPropor ;
   private byte[] P017C2_A1115AplIIGGTopeTip ;
   private byte[] P017C2_A1120AplIIGGTrat ;
   private int[] P017C2_A3CliCod ;
   private short[] P017C2_A1112AplIIGG ;
}

final  class getapliigg_totalmentegravado__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P017C2", "SELECT AplIIGGTopeFij, AplIIGGPropor, AplIIGGTopeTip, AplIIGGTrat, CliCod, AplIIGG FROM tipo_aplicacion_ganancias WHERE (CliCod = ?) AND ((AplIIGGTopeFij = 0)) AND (AplIIGGTrat = ?) AND (AplIIGGTopeTip = 3) AND (AplIIGGPropor = 1) ORDER BY CliCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,4);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
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
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               return;
      }
   }

}

