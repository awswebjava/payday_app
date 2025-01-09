package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class userasignarcliente extends GXProcedure
{
   public userasignarcliente( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( userasignarcliente.class ), "" );
   }

   public userasignarcliente( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( short aP0 ,
                        int aP1 ,
                        byte aP2 ,
                        byte aP3 ,
                        long aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( short aP0 ,
                             int aP1 ,
                             byte aP2 ,
                             byte aP3 ,
                             long aP4 )
   {
      userasignarcliente.this.AV8SecUserId = aP0;
      userasignarcliente.this.AV9CliCod = aP1;
      userasignarcliente.this.AV12RolId = aP2;
      userasignarcliente.this.AV11PerfilId = aP3;
      userasignarcliente.this.AV10MenuVerId = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      n1928MenuVerId = false ;
      n1925PerfilId = false ;
      n1923RolId = false ;
      n3CliCod = false ;
      /* Optimized UPDATE. */
      /* Using cursor P00C12 */
      pr_default.execute(0, new Object[] {Boolean.valueOf(n1928MenuVerId), Long.valueOf(AV10MenuVerId), Boolean.valueOf(n1925PerfilId), Byte.valueOf(AV11PerfilId), Boolean.valueOf(n1923RolId), Byte.valueOf(AV12RolId), Boolean.valueOf(n3CliCod), Integer.valueOf(AV9CliCod), Short.valueOf(AV8SecUserId)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("SecUser");
      /* End optimized UPDATE. */
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "userasignarcliente");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      pr_default = new DataStoreProvider(context, remoteHandle, new web.userasignarcliente__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV12RolId ;
   private byte AV11PerfilId ;
   private byte A1925PerfilId ;
   private byte A1923RolId ;
   private short AV8SecUserId ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int A3CliCod ;
   private long AV10MenuVerId ;
   private long A1928MenuVerId ;
   private boolean n1928MenuVerId ;
   private boolean n1925PerfilId ;
   private boolean n1923RolId ;
   private boolean n3CliCod ;
   private IDataStoreProvider pr_default ;
}

final  class userasignarcliente__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P00C12", "UPDATE SecUser SET MenuVerId=?, PerfilId=?, RolId=?, CliCod=?  WHERE SecUserId = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(1, ((Number) parms[1]).longValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(2, ((Number) parms[3]).byteValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(3, ((Number) parms[5]).byteValue());
               }
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(4, ((Number) parms[7]).intValue());
               }
               stmt.setShort(5, ((Number) parms[8]).shortValue());
               return;
      }
   }

}

