package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class conceptoesganancias extends GXProcedure
{
   public conceptoesganancias( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptoesganancias.class ), "" );
   }

   public conceptoesganancias( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              String aP2 ,
                              String aP3 )
   {
      conceptoesganancias.this.aP4 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String aP3 ,
                        boolean[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             boolean[] aP4 )
   {
      conceptoesganancias.this.AV12CliCod = aP0;
      conceptoesganancias.this.AV8ConCodigo = aP1;
      conceptoesganancias.this.AV9alcanzaGananciasConCodigo = aP2;
      conceptoesganancias.this.AV10SubTipoConCod1 = aP3;
      conceptoesganancias.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( ( GXutil.strcmp(AV8ConCodigo, AV9alcanzaGananciasConCodigo) != 0 ) && ( ( GXutil.strcmp(AV10SubTipoConCod1, new web.subtipocalculoganancias(remoteHandle, context).executeUdp( )) == 0 ) || ( GXutil.strcmp(AV10SubTipoConCod1, new web.subtipoganancias(remoteHandle, context).executeUdp( )) == 0 ) || ( GXutil.strcmp(AV8ConCodigo, new web.conceptodevolucionganancias(remoteHandle, context).executeUdp( AV12CliCod)) == 0 ) ) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         AV11conceptoEsGanancias = true ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = conceptoesganancias.this.AV11conceptoEsGanancias;
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
   private int AV12CliCod ;
   private String AV8ConCodigo ;
   private String AV9alcanzaGananciasConCodigo ;
   private String AV10SubTipoConCod1 ;
   private boolean AV11conceptoEsGanancias ;
   private boolean Cond_result ;
   private boolean[] aP4 ;
}

