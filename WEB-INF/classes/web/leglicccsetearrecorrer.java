package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class leglicccsetearrecorrer extends GXProcedure
{
   public leglicccsetearrecorrer( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( leglicccsetearrecorrer.class ), "" );
   }

   public leglicccsetearrecorrer( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        short aP4 ,
                        boolean aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             short aP4 ,
                             boolean aP5 )
   {
      leglicccsetearrecorrer.this.AV8CliCod = aP0;
      leglicccsetearrecorrer.this.AV9EmpCod = aP1;
      leglicccsetearrecorrer.this.AV10LegNumero = aP2;
      leglicccsetearrecorrer.this.AV11LegCuenLicTpo = aP3;
      leglicccsetearrecorrer.this.AV12LegCuenAnio = aP4;
      leglicccsetearrecorrer.this.AV13LegCuLIncluir = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( AV13LegCuLIncluir )
      {
         /* Optimized UPDATE. */
         /* Using cursor P02902 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LegNumero), AV11LegCuenLicTpo, Short.valueOf(AV12LegCuenAnio)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_cuenta_licencias");
         /* End optimized UPDATE. */
      }
      else
      {
         /* Optimized UPDATE. */
         /* Using cursor P02903 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LegNumero), AV11LegCuenLicTpo, Short.valueOf(AV12LegCuenAnio)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_cuenta_licencias");
         /* End optimized UPDATE. */
      }
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "leglicccsetearrecorrer");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      pr_default = new DataStoreProvider(context, remoteHandle, new web.leglicccsetearrecorrer__default(),
         new Object[] {
             new Object[] {
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short AV12LegCuenAnio ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10LegNumero ;
   private String AV11LegCuenLicTpo ;
   private boolean AV13LegCuLIncluir ;
   private IDataStoreProvider pr_default ;
}

final  class leglicccsetearrecorrer__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P02902", "UPDATE legajo_cuenta_licencias SET LegCuLIncluir=TRUE  WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and LegCuenLicTpo = ( ?) and LegCuenAnio >= ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P02903", "UPDATE legajo_cuenta_licencias SET LegCuLIncluir=FALSE  WHERE (CliCod = ? and EmpCod = ? and LegNumero = ? and LegCuenLicTpo = ( ?)) AND (LegCuenAnio <= ?)", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
      }
   }

}

