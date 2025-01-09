package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class setearlegsuelcalcom extends GXProcedure
{
   public setearlegsuelcalcom( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( setearlegsuelcalcom.class ), "" );
   }

   public setearlegsuelcalcom( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        short aP3 ,
                        boolean aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short aP3 ,
                             boolean aP4 )
   {
      setearlegsuelcalcom.this.AV11CliCod = aP0;
      setearlegsuelcalcom.this.AV10EmpCod = aP1;
      setearlegsuelcalcom.this.AV9LegNumero = aP2;
      setearlegsuelcalcom.this.AV8LegSuelSec = aP3;
      setearlegsuelcalcom.this.AV12LegSuelCalCom = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Optimized UPDATE. */
      /* Using cursor P02D52 */
      pr_default.execute(0, new Object[] {Boolean.valueOf(AV12LegSuelCalCom), Integer.valueOf(AV11CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV9LegNumero), Short.valueOf(AV8LegSuelSec)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_sueldos");
      /* End optimized UPDATE. */
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "setearlegsuelcalcom");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      pr_default = new DataStoreProvider(context, remoteHandle, new web.setearlegsuelcalcom__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short AV8LegSuelSec ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV9LegNumero ;
   private boolean AV12LegSuelCalCom ;
   private boolean A2359LegSuelCalCom ;
   private IDataStoreProvider pr_default ;
}

final  class setearlegsuelcalcom__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P02D52", "UPDATE legajo_sueldos SET LegSuelCalCom=?  WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and LegSuelSec = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
      }
   }

}

