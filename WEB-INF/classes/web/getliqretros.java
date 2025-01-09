package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getliqretros extends GXProcedure
{
   public getliqretros( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getliqretros.class ), "" );
   }

   public getliqretros( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<web.Sdtsdt_liquidacion2_sdt_liquidacion2Item> executeUdp( int aP0 ,
                                                                                     short aP1 ,
                                                                                     int aP2 )
   {
      getliqretros.this.aP3 = new GXBaseCollection[] {new GXBaseCollection<web.Sdtsdt_liquidacion2_sdt_liquidacion2Item>()};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        GXBaseCollection<web.Sdtsdt_liquidacion2_sdt_liquidacion2Item>[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             GXBaseCollection<web.Sdtsdt_liquidacion2_sdt_liquidacion2Item>[] aP3 )
   {
      getliqretros.this.AV12CliCod = aP0;
      getliqretros.this.AV8EmpCod = aP1;
      getliqretros.this.AV9LiqRelNro = aP2;
      getliqretros.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P020K2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV9LiqRelNro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2112LiqRelNro = P020K2_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P020K2_n2112LiqRelNro[0] ;
         A1EmpCod = P020K2_A1EmpCod[0] ;
         A3CliCod = P020K2_A3CliCod[0] ;
         A874LiqNombre = P020K2_A874LiqNombre[0] ;
         A31LiqNro = P020K2_A31LiqNro[0] ;
         AV11item = (web.Sdtsdt_liquidacion2_sdt_liquidacion2Item)new web.Sdtsdt_liquidacion2_sdt_liquidacion2Item(remoteHandle, context);
         AV11item.setgxTv_Sdtsdt_liquidacion2_sdt_liquidacion2Item_Liqnombre( A874LiqNombre );
         AV11item.setgxTv_Sdtsdt_liquidacion2_sdt_liquidacion2Item_Liqnro( A31LiqNro );
         AV10sdt_liquidacion2.add(AV11item, 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getliqretros.this.AV10sdt_liquidacion2;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10sdt_liquidacion2 = new GXBaseCollection<web.Sdtsdt_liquidacion2_sdt_liquidacion2Item>(web.Sdtsdt_liquidacion2_sdt_liquidacion2Item.class, "sdt_liquidacion2Item", "PayDay", remoteHandle);
      scmdbuf = "" ;
      P020K2_A2112LiqRelNro = new int[1] ;
      P020K2_n2112LiqRelNro = new boolean[] {false} ;
      P020K2_A1EmpCod = new short[1] ;
      P020K2_A3CliCod = new int[1] ;
      P020K2_A874LiqNombre = new String[] {""} ;
      P020K2_A31LiqNro = new int[1] ;
      A874LiqNombre = "" ;
      AV11item = new web.Sdtsdt_liquidacion2_sdt_liquidacion2Item(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getliqretros__default(),
         new Object[] {
             new Object[] {
            P020K2_A2112LiqRelNro, P020K2_n2112LiqRelNro, P020K2_A1EmpCod, P020K2_A3CliCod, P020K2_A874LiqNombre, P020K2_A31LiqNro
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV9LiqRelNro ;
   private int A2112LiqRelNro ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private String scmdbuf ;
   private boolean n2112LiqRelNro ;
   private String A874LiqNombre ;
   private GXBaseCollection<web.Sdtsdt_liquidacion2_sdt_liquidacion2Item>[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P020K2_A2112LiqRelNro ;
   private boolean[] P020K2_n2112LiqRelNro ;
   private short[] P020K2_A1EmpCod ;
   private int[] P020K2_A3CliCod ;
   private String[] P020K2_A874LiqNombre ;
   private int[] P020K2_A31LiqNro ;
   private GXBaseCollection<web.Sdtsdt_liquidacion2_sdt_liquidacion2Item> AV10sdt_liquidacion2 ;
   private web.Sdtsdt_liquidacion2_sdt_liquidacion2Item AV11item ;
}

final  class getliqretros__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P020K2", "SELECT LiqRelNro, EmpCod, CliCod, LiqNombre, LiqNro FROM Liquidacion WHERE CliCod = ? and EmpCod = ? and LiqRelNro = ? ORDER BY CliCod, EmpCod, LiqRelNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((short[]) buf[2])[0] = rslt.getShort(2);
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               ((int[]) buf[5])[0] = rslt.getInt(5);
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

