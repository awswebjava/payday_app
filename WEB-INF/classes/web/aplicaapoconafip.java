package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class aplicaapoconafip extends GXProcedure
{
   public aplicaapoconafip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( aplicaapoconafip.class ), "" );
   }

   public aplicaapoconafip( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 ,
                              String aP1 ,
                              String aP2 ,
                              String aP3 )
   {
      aplicaapoconafip.this.aP4 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String aP3 ,
                        boolean[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             boolean[] aP4 )
   {
      aplicaapoconafip.this.AV9aporte_o_contribucion = aP0;
      aplicaapoconafip.this.AV10subsistema = aP1;
      aplicaapoconafip.this.AV8TipoConCod = aP2;
      aplicaapoconafip.this.AV12SubTipoConCod1 = aP3;
      aplicaapoconafip.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV11aplica = false ;
      if ( GXutil.strcmp(AV8TipoConCod, "DES_ARG") != 0 )
      {
         AV11aplica = true ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = aplicaapoconafip.this.AV11aplica;
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
   private String AV9aporte_o_contribucion ;
   private String AV10subsistema ;
   private String AV8TipoConCod ;
   private String AV12SubTipoConCod1 ;
   private boolean AV11aplica ;
   private boolean[] aP4 ;
}

