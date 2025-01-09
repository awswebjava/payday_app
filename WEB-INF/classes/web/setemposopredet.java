package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class setemposopredet extends GXProcedure
{
   public setemposopredet( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( setemposopredet.class ), "" );
   }

   public setemposopredet( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 )
   {
      setemposopredet.this.AV8CliCod = aP0;
      setemposopredet.this.AV9EmpCod = aP1;
      setemposopredet.this.AV10EmpOsoCod = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( ! (GXutil.strcmp("", AV10EmpOsoCod)==0) )
      {
         n1965EmpOsoCod = false ;
         /* Optimized UPDATE. */
         /* Using cursor P027F2 */
         pr_default.execute(0, new Object[] {Boolean.valueOf(n1965EmpOsoCod), AV10EmpOsoCod, Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresa");
         /* End optimized UPDATE. */
      }
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      A1965EmpOsoCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.setemposopredet__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private String AV10EmpOsoCod ;
   private String A1965EmpOsoCod ;
   private boolean n1965EmpOsoCod ;
   private IDataStoreProvider pr_default ;
}

final  class setemposopredet__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P027F2", "UPDATE Empresa SET EmpOsoCod=?  WHERE CliCod = ? and EmpCod = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               stmt.setInt(2, ((Number) parms[2]).intValue());
               stmt.setShort(3, ((Number) parms[3]).shortValue());
               return;
      }
   }

}

