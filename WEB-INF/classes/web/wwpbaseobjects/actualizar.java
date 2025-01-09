package web.wwpbaseobjects ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class actualizar extends GXProcedure
{
   public actualizar( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( actualizar.class ), "" );
   }

   public actualizar( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        int aP1 ,
                        int aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             int aP1 ,
                             int aP2 )
   {
      actualizar.this.AV8padreCliCod = aP0;
      actualizar.this.AV9CliCod = aP1;
      actualizar.this.AV10CliUpdRelSec = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_int1[0] = 0 ;
      GXv_char2[0] = "" ;
      GXv_int3[0] = (short)(0) ;
      GXv_int4[0] = 0 ;
      new web.importarconceptos2(remoteHandle, context).execute( AV8padreCliCod, AV9CliCod, "", false, (short)(0), "", AV10CliUpdRelSec, GXv_int1, GXv_char2, GXv_int3, GXv_int4) ;
      new web.updatevariables(remoteHandle, context).execute( AV8padreCliCod, AV9CliCod, AV10CliUpdRelSec) ;
      new web.updatevariablevalores(remoteHandle, context).execute( AV8padreCliCod, AV9CliCod, AV10CliUpdRelSec) ;
      new web.updateconvenioparticularidades(remoteHandle, context).execute( AV8padreCliCod, AV9CliCod, AV10CliUpdRelSec) ;
      new web.updateconveniovacaciones(remoteHandle, context).execute( AV8padreCliCod, AV9CliCod, AV10CliUpdRelSec) ;
      new web.updateconveniofondocese(remoteHandle, context).execute( AV8padreCliCod, AV9CliCod, AV10CliUpdRelSec) ;
      new web.updatecategorias(remoteHandle, context).execute( AV8padreCliCod, AV9CliCod, AV10CliUpdRelSec) ;
      new web.updateescalasalarial(remoteHandle, context).execute( AV8padreCliCod, AV9CliCod, AV10CliUpdRelSec) ;
      new web.updatecategoriaprovincias(remoteHandle, context).execute( AV8padreCliCod, AV9CliCod, AV10CliUpdRelSec) ;
      new web.updateconvenioimportes(remoteHandle, context).execute( AV8padreCliCod, AV9CliCod, AV10CliUpdRelSec) ;
      new web.updateconvenioadicional(remoteHandle, context).execute( AV8padreCliCod, AV9CliCod, AV10CliUpdRelSec) ;
      new web.updateconvenioadicionalimportes(remoteHandle, context).execute( AV8padreCliCod, AV9CliCod, AV10CliUpdRelSec) ;
      new web.updateconvenioadicionalcancelan(remoteHandle, context).execute( AV8padreCliCod, AV9CliCod, AV10CliUpdRelSec) ;
      new web.updateconvenioadicionalalicuotas(remoteHandle, context).execute( AV8padreCliCod, AV9CliCod, AV10CliUpdRelSec) ;
      new web.updateconveniobasecalculos(remoteHandle, context).execute( AV8padreCliCod, AV9CliCod, AV10CliUpdRelSec) ;
      new web.updateconveniotiposdetrabajo(remoteHandle, context).execute( AV8padreCliCod, AV9CliCod, AV10CliUpdRelSec) ;
      new web.updateconveniohsextpordia(remoteHandle, context).execute( AV8padreCliCod, AV9CliCod, AV10CliUpdRelSec) ;
      new web.updatebancos(remoteHandle, context).execute( AV8padreCliCod, AV9CliCod, AV10CliUpdRelSec) ;
      new web.updateobrassociales(remoteHandle, context).execute( AV8padreCliCod, AV9CliCod, AV10CliUpdRelSec) ;
      new web.updateareas(remoteHandle, context).execute( AV8padreCliCod, AV9CliCod, AV10CliUpdRelSec) ;
      new web.updatepuestos(remoteHandle, context).execute( AV8padreCliCod, AV9CliCod, AV10CliUpdRelSec) ;
      GXv_int3[0] = AV11PaiCod ;
      new web.clientegetpais(remoteHandle, context).execute( AV9CliCod, GXv_int3) ;
      actualizar.this.AV11PaiCod = GXv_int3[0] ;
      /* Using cursor P01T12 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P01T12_A3CliCod[0] ;
         A1EmpCod = P01T12_A1EmpCod[0] ;
         new web.copiarbasecalcdepaiaemp(remoteHandle, context).execute( AV11PaiCod, AV9CliCod, A1EmpCod, AV10CliUpdRelSec) ;
         new web.copiarconfhorasextdepaiaemp(remoteHandle, context).execute( AV11PaiCod, AV9CliCod, A1EmpCod, AV10CliUpdRelSec) ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      GXv_boolean5[0] = AV13alguienYaActualizo ;
      new web.alguienyaactualizoliberacion(remoteHandle, context).execute( AV8padreCliCod, AV10CliUpdRelSec, GXv_boolean5) ;
      actualizar.this.AV13alguienYaActualizo = GXv_boolean5[0] ;
      /* Optimized UPDATE. */
      /* Using cursor P01T13 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV9CliCod), Integer.valueOf(AV8padreCliCod), Integer.valueOf(AV10CliUpdRelSec)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Cliente_Update");
      /* End optimized UPDATE. */
      if ( ! AV13alguienYaActualizo )
      {
      }
      new web.alert(remoteHandle, context).execute( "success", httpContext.getMessage( "Se aplicó la actualización correctamente", "")) ;
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.actualizar");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXv_int1 = new long[1] ;
      GXv_char2 = new String[1] ;
      GXv_int4 = new int[1] ;
      GXv_int3 = new short[1] ;
      scmdbuf = "" ;
      P01T12_A3CliCod = new int[1] ;
      P01T12_A1EmpCod = new short[1] ;
      GXv_boolean5 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.wwpbaseobjects.actualizar__default(),
         new Object[] {
             new Object[] {
            P01T12_A3CliCod, P01T12_A1EmpCod
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11PaiCod ;
   private short GXv_int3[] ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV8padreCliCod ;
   private int AV9CliCod ;
   private int AV10CliUpdRelSec ;
   private int GXv_int4[] ;
   private int A3CliCod ;
   private long GXv_int1[] ;
   private String GXv_char2[] ;
   private String scmdbuf ;
   private boolean AV13alguienYaActualizo ;
   private boolean GXv_boolean5[] ;
   private IDataStoreProvider pr_default ;
   private int[] P01T12_A3CliCod ;
   private short[] P01T12_A1EmpCod ;
}

final  class actualizar__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01T12", "SELECT CliCod, EmpCod FROM Empresa WHERE CliCod = ? ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P01T13", "UPDATE Cliente_Update SET CliUpdDTApl=timezone('UTC', NOW())  WHERE CliCod = ? and CliUpdCliCod = ? and CliUpdRelSec = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
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
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

