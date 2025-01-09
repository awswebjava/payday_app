package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class esdeduccionuotrosempleos extends GXProcedure
{
   public esdeduccionuotrosempleos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( esdeduccionuotrosempleos.class ), "" );
   }

   public esdeduccionuotrosempleos( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 ,
                              String aP1 )
   {
      esdeduccionuotrosempleos.this.aP2 = new boolean[] {false};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        boolean[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             boolean[] aP2 )
   {
      esdeduccionuotrosempleos.this.AV8SubTipoConCod1 = aP0;
      esdeduccionuotrosempleos.this.AV9SubTipoConCod2 = aP1;
      esdeduccionuotrosempleos.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( GXutil.strcmp(AV8SubTipoConCod1, new web.subtipocalculoganancias(remoteHandle, context).executeUdp( )) == 0 )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         if ( ( GXutil.strcmp(AV9SubTipoConCod2, new web.subtipo2deduccionesgeneralesanuales(remoteHandle, context).executeUdp( )) == 0 ) || ( GXutil.strcmp(AV9SubTipoConCod2, new web.subtipo2deduccionesgenerales(remoteHandle, context).executeUdp( )) == 0 ) || ( GXutil.strcmp(AV9SubTipoConCod2, new web.subtipo2otrosempleos(remoteHandle, context).executeUdp( )) == 0 ) )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            AV10es = true ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = esdeduccionuotrosempleos.this.AV10es;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8SubTipoConCod1 ;
   private String AV9SubTipoConCod2 ;
   private boolean AV10es ;
   private boolean Cond_result ;
   private boolean[] aP2 ;
}

