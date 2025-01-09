package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class iniempylegfreymodtra extends GXProcedure
{
   public iniempylegfreymodtra( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( iniempylegfreymodtra.class ), "" );
   }

   public iniempylegfreymodtra( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( )
   {
      execute_int();
   }

   private void execute_int( )
   {
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Optimized UPDATE. */
      cmdBuffer = " LOCK TABLE Empresa IN EXCLUSIVE MODE ";
      ExecuteDirectSQL.execute(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      /* Using cursor P02LA2 */
      pr_default.execute(0);
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresa");
      /* End optimized UPDATE. */
      /* Optimized UPDATE. */
      cmdBuffer = " LOCK TABLE Legajo IN EXCLUSIVE MODE ";
      ExecuteDirectSQL.execute(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      /* Using cursor P02LA3 */
      pr_default.execute(1);
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Legajo");
      /* End optimized UPDATE. */
      /* Using cursor P02LA4 */
      pr_default.execute(2);
      while ( (pr_default.getStatus(2) != 101) )
      {
         A2409LiqModTra = P02LA4_A2409LiqModTra[0] ;
         A268LiqClase = P02LA4_A268LiqClase[0] ;
         n268LiqClase = P02LA4_n268LiqClase[0] ;
         A2414LiqFrecPag = P02LA4_A2414LiqFrecPag[0] ;
         A3CliCod = P02LA4_A3CliCod[0] ;
         A1EmpCod = P02LA4_A1EmpCod[0] ;
         A31LiqNro = P02LA4_A31LiqNro[0] ;
         A32TLiqCod = P02LA4_A32TLiqCod[0] ;
         n32TLiqCod = P02LA4_n32TLiqCod[0] ;
         A283LiqPeriodo = P02LA4_A283LiqPeriodo[0] ;
         A2410LiqPerDes = P02LA4_A2410LiqPerDes[0] ;
         A2411LiqPerHas = P02LA4_A2411LiqPerHas[0] ;
         A2409LiqModTra = "E" ;
         if ( A268LiqClase == 0 )
         {
            A2414LiqFrecPag = (byte)(1) ;
         }
         else
         {
            A2414LiqFrecPag = (byte)(2) ;
         }
         GXv_date1[0] = AV8LiqPerDes ;
         GXv_date2[0] = AV9LiqPerHas ;
         new web.getrangoperiodos(remoteHandle, context).execute( A3CliCod, A1EmpCod, A31LiqNro, 0, A32TLiqCod, A2414LiqFrecPag, A283LiqPeriodo, false, GXv_date1, GXv_date2) ;
         iniempylegfreymodtra.this.AV8LiqPerDes = GXv_date1[0] ;
         iniempylegfreymodtra.this.AV9LiqPerHas = GXv_date2[0] ;
         A2410LiqPerDes = AV8LiqPerDes ;
         A2411LiqPerHas = AV9LiqPerHas ;
         /* Using cursor P02LA5 */
         pr_default.execute(3, new Object[] {A2409LiqModTra, Byte.valueOf(A2414LiqFrecPag), A2410LiqPerDes, A2411LiqPerHas, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Liquidacion");
         pr_default.readNext(2);
      }
      pr_default.close(2);
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "iniempylegfreymodtra");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      cmdBuffer = "" ;
      scmdbuf = "" ;
      P02LA4_A2409LiqModTra = new String[] {""} ;
      P02LA4_A268LiqClase = new byte[1] ;
      P02LA4_n268LiqClase = new boolean[] {false} ;
      P02LA4_A2414LiqFrecPag = new byte[1] ;
      P02LA4_A3CliCod = new int[1] ;
      P02LA4_A1EmpCod = new short[1] ;
      P02LA4_A31LiqNro = new int[1] ;
      P02LA4_A32TLiqCod = new String[] {""} ;
      P02LA4_n32TLiqCod = new boolean[] {false} ;
      P02LA4_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P02LA4_A2410LiqPerDes = new java.util.Date[] {GXutil.nullDate()} ;
      P02LA4_A2411LiqPerHas = new java.util.Date[] {GXutil.nullDate()} ;
      A2409LiqModTra = "" ;
      A32TLiqCod = "" ;
      A283LiqPeriodo = GXutil.nullDate() ;
      A2410LiqPerDes = GXutil.nullDate() ;
      A2411LiqPerHas = GXutil.nullDate() ;
      AV8LiqPerDes = GXutil.nullDate() ;
      GXv_date1 = new java.util.Date[1] ;
      AV9LiqPerHas = GXutil.nullDate() ;
      GXv_date2 = new java.util.Date[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.iniempylegfreymodtra__default(),
         new Object[] {
             new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            P02LA4_A2409LiqModTra, P02LA4_A268LiqClase, P02LA4_n268LiqClase, P02LA4_A2414LiqFrecPag, P02LA4_A3CliCod, P02LA4_A1EmpCod, P02LA4_A31LiqNro, P02LA4_A32TLiqCod, P02LA4_n32TLiqCod, P02LA4_A283LiqPeriodo,
            P02LA4_A2410LiqPerDes, P02LA4_A2411LiqPerHas
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A268LiqClase ;
   private byte A2414LiqFrecPag ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private String cmdBuffer ;
   private String scmdbuf ;
   private String A2409LiqModTra ;
   private String A32TLiqCod ;
   private java.util.Date A283LiqPeriodo ;
   private java.util.Date A2410LiqPerDes ;
   private java.util.Date A2411LiqPerHas ;
   private java.util.Date AV8LiqPerDes ;
   private java.util.Date GXv_date1[] ;
   private java.util.Date AV9LiqPerHas ;
   private java.util.Date GXv_date2[] ;
   private boolean n268LiqClase ;
   private boolean n32TLiqCod ;
   private IDataStoreProvider pr_default ;
   private String[] P02LA4_A2409LiqModTra ;
   private byte[] P02LA4_A268LiqClase ;
   private boolean[] P02LA4_n268LiqClase ;
   private byte[] P02LA4_A2414LiqFrecPag ;
   private int[] P02LA4_A3CliCod ;
   private short[] P02LA4_A1EmpCod ;
   private int[] P02LA4_A31LiqNro ;
   private String[] P02LA4_A32TLiqCod ;
   private boolean[] P02LA4_n32TLiqCod ;
   private java.util.Date[] P02LA4_A283LiqPeriodo ;
   private java.util.Date[] P02LA4_A2410LiqPerDes ;
   private java.util.Date[] P02LA4_A2411LiqPerHas ;
}

final  class iniempylegfreymodtra__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P02LA2", "UPDATE Empresa SET EmpModAuto=FALSE, EmpModEmpl=TRUE, EmpModTra='E' ", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P02LA3", "UPDATE Legajo SET LegModTra='E' ", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P02LA4", "SELECT LiqModTra, LiqClase, LiqFrecPag, CliCod, EmpCod, LiqNro, TLiqCod, LiqPeriodo, LiqPerDes, LiqPerHas FROM Liquidacion ORDER BY CliCod, EmpCod, LiqNro  FOR UPDATE OF Liquidacion",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P02LA5", "SAVEPOINT gxupdate;UPDATE Liquidacion SET LiqModTra=?, LiqFrecPag=?, LiqPerDes=?, LiqPerHas=?  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((byte[]) buf[3])[0] = rslt.getByte(3);
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((short[]) buf[5])[0] = rslt.getShort(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDate(8);
               ((java.util.Date[]) buf[10])[0] = rslt.getGXDate(9);
               ((java.util.Date[]) buf[11])[0] = rslt.getGXDate(10);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 3 :
               stmt.setString(1, (String)parms[0], 1);
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               return;
      }
   }

}

