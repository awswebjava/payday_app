package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getsucursal extends GXProcedure
{
   public getsucursal( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getsucursal.class ), "" );
   }

   public getsucursal( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             String aP2 )
   {
      getsucursal.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             String[] aP3 )
   {
      getsucursal.this.AV10CliCod = aP0;
      getsucursal.this.AV8EmpCod = aP1;
      getsucursal.this.AV9SucCodigo = aP2;
      getsucursal.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P027D2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV8EmpCod), AV9SucCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1243SucCodigo = P027D2_A1243SucCodigo[0] ;
         A1EmpCod = P027D2_A1EmpCod[0] ;
         A3CliCod = P027D2_A3CliCod[0] ;
         A1244SucDescrip = P027D2_A1244SucDescrip[0] ;
         AV11SucDescrip = A1244SucDescrip ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getsucursal.this.AV11SucDescrip;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11SucDescrip = "" ;
      scmdbuf = "" ;
      P027D2_A1243SucCodigo = new String[] {""} ;
      P027D2_A1EmpCod = new short[1] ;
      P027D2_A3CliCod = new int[1] ;
      P027D2_A1244SucDescrip = new String[] {""} ;
      A1243SucCodigo = "" ;
      A1244SucDescrip = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getsucursal__default(),
         new Object[] {
             new Object[] {
            P027D2_A1243SucCodigo, P027D2_A1EmpCod, P027D2_A3CliCod, P027D2_A1244SucDescrip
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int A3CliCod ;
   private String AV9SucCodigo ;
   private String scmdbuf ;
   private String A1243SucCodigo ;
   private String AV11SucDescrip ;
   private String A1244SucDescrip ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private String[] P027D2_A1243SucCodigo ;
   private short[] P027D2_A1EmpCod ;
   private int[] P027D2_A3CliCod ;
   private String[] P027D2_A1244SucDescrip ;
}

final  class getsucursal__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P027D2", "SELECT SucCodigo, EmpCod, CliCod, SucDescrip FROM Sucursal WHERE CliCod = ? and EmpCod = ? and SucCodigo = ( ?) ORDER BY CliCod, EmpCod, SucCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
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

