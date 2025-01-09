package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class setlegwarning extends GXProcedure
{
   public setlegwarning( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( setlegwarning.class ), "" );
   }

   public setlegwarning( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        boolean aP3 ,
                        String aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             boolean aP3 ,
                             String aP4 )
   {
      setlegwarning.this.AV11CliCod = aP0;
      setlegwarning.this.AV10EmpCod = aP1;
      setlegwarning.this.AV8LegNumero = aP2;
      setlegwarning.this.AV12LegIncompleto = aP3;
      setlegwarning.this.AV9LegMigrWarn = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      n2263LegMigrWarn = false ;
      /* Optimized UPDATE. */
      /* Using cursor P02AU2 */
      pr_default.execute(0, new Object[] {Boolean.valueOf(AV12LegIncompleto), Boolean.valueOf(n2263LegMigrWarn), AV9LegMigrWarn, Integer.valueOf(AV11CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV8LegNumero)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Legajo");
      /* End optimized UPDATE. */
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "setlegwarning");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      A2263LegMigrWarn = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.setlegwarning__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV8LegNumero ;
   private boolean AV12LegIncompleto ;
   private boolean n2263LegMigrWarn ;
   private boolean A2267LegIncompleto ;
   private String AV9LegMigrWarn ;
   private String A2263LegMigrWarn ;
   private IDataStoreProvider pr_default ;
}

final  class setlegwarning__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P02AU2", "UPDATE Legajo SET LegIncompleto=?, LegMigrWarn=?  WHERE CliCod = ? and EmpCod = ? and LegNumero = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(2, (String)parms[2]);
               }
               stmt.setInt(3, ((Number) parms[3]).intValue());
               stmt.setShort(4, ((Number) parms[4]).shortValue());
               stmt.setInt(5, ((Number) parms[5]).intValue());
               return;
      }
   }

}

