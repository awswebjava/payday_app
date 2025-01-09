package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class eliminarliberacion extends GXProcedure
{
   public eliminarliberacion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( eliminarliberacion.class ), "" );
   }

   public eliminarliberacion( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             int aP1 )
   {
      eliminarliberacion.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        int aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             int aP1 ,
                             String[] aP2 )
   {
      eliminarliberacion.this.AV8CliCod = aP0;
      eliminarliberacion.this.AV9CliRelSec = aP1;
      eliminarliberacion.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_boolean1[0] = AV10hay ;
      new web.validarfecharelease(remoteHandle, context).execute( AV8CliCod, AV9CliRelSec, GXv_boolean1) ;
      eliminarliberacion.this.AV10hay = GXv_boolean1[0] ;
      if ( AV10hay )
      {
         AV11errores.add(httpContext.getMessage( "Hay al menos una actualización de cliente aplicada", ""), 0);
         AV12errorHay = true ;
      }
      else
      {
         /* Optimized DELETE. */
         /* Using cursor P01VN2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Integer.valueOf(AV9CliRelSec)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Cliente_Update");
         /* End optimized DELETE. */
      }
      GXv_boolean1[0] = AV10hay ;
      new web.hayliberacioncategoria(remoteHandle, context).execute( AV8CliCod, AV9CliRelSec, GXv_boolean1) ;
      eliminarliberacion.this.AV10hay = GXv_boolean1[0] ;
      if ( AV10hay )
      {
         AV11errores.add(httpContext.getMessage( "Hay una categoría marcada con la liberación", ""), 0);
         AV12errorHay = true ;
      }
      GXv_boolean1[0] = AV10hay ;
      new web.hayliberacionescala(remoteHandle, context).execute( AV8CliCod, AV9CliRelSec, GXv_boolean1) ;
      eliminarliberacion.this.AV10hay = GXv_boolean1[0] ;
      if ( AV10hay )
      {
         AV11errores.add(httpContext.getMessage( "Hay una Escala salarial marcada con la liberación", ""), 0);
         AV12errorHay = true ;
      }
      GXv_boolean1[0] = AV10hay ;
      new web.hayliberacionconvenioimporte(remoteHandle, context).execute( AV8CliCod, AV9CliRelSec, GXv_boolean1) ;
      eliminarliberacion.this.AV10hay = GXv_boolean1[0] ;
      if ( AV10hay )
      {
         AV11errores.add(httpContext.getMessage( "Hay un importe de convenio marcado con la liberación", ""), 0);
         AV12errorHay = true ;
      }
      GXv_boolean1[0] = AV10hay ;
      new web.hayliberacionconcepto(remoteHandle, context).execute( AV8CliCod, AV9CliRelSec, GXv_boolean1) ;
      eliminarliberacion.this.AV10hay = GXv_boolean1[0] ;
      if ( AV10hay )
      {
         AV11errores.add(httpContext.getMessage( "Hay un concepto marcado con la liberación", ""), 0);
         AV12errorHay = true ;
      }
      GXv_boolean1[0] = AV10hay ;
      new web.hayliberacionadicionalimporte(remoteHandle, context).execute( AV8CliCod, AV9CliRelSec, GXv_boolean1) ;
      eliminarliberacion.this.AV10hay = GXv_boolean1[0] ;
      if ( AV10hay )
      {
         AV11errores.add(httpContext.getMessage( "Hay un importe de adicional marcado con la liberación", ""), 0);
         AV12errorHay = true ;
      }
      GXv_boolean1[0] = AV10hay ;
      new web.hayliberacionadicionalopcion(remoteHandle, context).execute( AV8CliCod, AV9CliRelSec, GXv_boolean1) ;
      eliminarliberacion.this.AV10hay = GXv_boolean1[0] ;
      if ( AV10hay )
      {
         AV11errores.add(httpContext.getMessage( "Hay una opción de adicional marcada con la liberación", ""), 0);
         AV12errorHay = true ;
      }
      GXv_boolean1[0] = AV10hay ;
      new web.hayliberacionadicional(remoteHandle, context).execute( AV8CliCod, AV9CliRelSec, GXv_boolean1) ;
      eliminarliberacion.this.AV10hay = GXv_boolean1[0] ;
      if ( AV10hay )
      {
         AV11errores.add(httpContext.getMessage( "Hay una adicional marcado con la liberación", ""), 0);
         AV12errorHay = true ;
      }
      GXv_boolean1[0] = AV10hay ;
      new web.hayliberacionsitcanceadi(remoteHandle, context).execute( AV8CliCod, AV9CliRelSec, GXv_boolean1) ;
      eliminarliberacion.this.AV10hay = GXv_boolean1[0] ;
      if ( AV10hay )
      {
         AV11errores.add(httpContext.getMessage( "Hay estado que cancela adicional marcado con la liberación", ""), 0);
         AV12errorHay = true ;
      }
      GXv_boolean1[0] = AV10hay ;
      new web.hayliberacionconvenio(remoteHandle, context).execute( AV8CliCod, AV9CliRelSec, GXv_boolean1) ;
      eliminarliberacion.this.AV10hay = GXv_boolean1[0] ;
      if ( AV10hay )
      {
         AV11errores.add(httpContext.getMessage( "Hay convenio marcado con la liberación", ""), 0);
         AV12errorHay = true ;
      }
      GXv_boolean1[0] = AV10hay ;
      new web.hayliberacionconveniovacaciones(remoteHandle, context).execute( AV8CliCod, AV9CliRelSec, GXv_boolean1) ;
      eliminarliberacion.this.AV10hay = GXv_boolean1[0] ;
      if ( AV10hay )
      {
         AV11errores.add(httpContext.getMessage( "Hay registro de vacaciones por convenio marcado con la liberación", ""), 0);
         AV12errorHay = true ;
      }
      GXv_boolean1[0] = AV10hay ;
      new web.hayliberacionconveniovacaciones(remoteHandle, context).execute( AV8CliCod, AV9CliRelSec, GXv_boolean1) ;
      eliminarliberacion.this.AV10hay = GXv_boolean1[0] ;
      if ( AV10hay )
      {
         AV11errores.add(httpContext.getMessage( "Hay registro de vacaciones por convenio marcado con la liberación", ""), 0);
         AV12errorHay = true ;
      }
      GXv_boolean1[0] = AV10hay ;
      new web.hayliberacionvariablevalor(remoteHandle, context).execute( AV8CliCod, AV9CliRelSec, GXv_boolean1) ;
      eliminarliberacion.this.AV10hay = GXv_boolean1[0] ;
      if ( AV10hay )
      {
         AV11errores.add(httpContext.getMessage( "Hay valor de variable marcado con la liberación", ""), 0);
         AV12errorHay = true ;
      }
      GXv_boolean1[0] = AV10hay ;
      new web.hayliberacionvariable(remoteHandle, context).execute( AV8CliCod, AV9CliRelSec, GXv_boolean1) ;
      eliminarliberacion.this.AV10hay = GXv_boolean1[0] ;
      if ( AV10hay )
      {
         AV11errores.add(httpContext.getMessage( "Hay variable marcada con la liberación", ""), 0);
         AV12errorHay = true ;
      }
      if ( AV12errorHay )
      {
         AV13error = httpContext.getMessage( "Hay items marcados con la liberación", "") ;
      }
      else
      {
         /* Optimized DELETE. */
         /* Using cursor P01VN3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV8CliCod), Integer.valueOf(AV9CliRelSec)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Cliente_Release");
         /* End optimized DELETE. */
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = eliminarliberacion.this.AV13error;
      Application.commitDataStores(context, remoteHandle, pr_default, "eliminarliberacion");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13error = "" ;
      AV11errores = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean1 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.eliminarliberacion__default(),
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

   private short Gx_err ;
   private int AV8CliCod ;
   private int AV9CliRelSec ;
   private boolean AV10hay ;
   private boolean AV12errorHay ;
   private boolean GXv_boolean1[] ;
   private String AV13error ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private GXSimpleCollection<String> AV11errores ;
}

final  class eliminarliberacion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01VN2", "DELETE FROM Cliente_Update  WHERE CliUpdCliCod = ? and CliUpdRelSec = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01VN3", "DELETE FROM Cliente_Release  WHERE CliCod = ? and CliRelSec = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setInt(2, ((Number) parms[1]).intValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               return;
      }
   }

}

