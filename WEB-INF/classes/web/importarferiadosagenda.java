package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class importarferiadosagenda extends GXProcedure
{
   public importarferiadosagenda( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importarferiadosagenda.class ), "" );
   }

   public importarferiadosagenda( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( short aP0 ,
                             short aP1 )
   {
      importarferiadosagenda.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( short aP0 ,
                        short aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( short aP0 ,
                             short aP1 ,
                             String[] aP2 )
   {
      importarferiadosagenda.this.AV10PaiCod = aP0;
      importarferiadosagenda.this.AV8anio = aP1;
      importarferiadosagenda.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV9json ;
      GXv_char2[0] = AV11error ;
      new web.fetchferiadosagenda(remoteHandle, context).execute( AV8anio, GXv_char1, GXv_char2) ;
      importarferiadosagenda.this.AV9json = GXv_char1[0] ;
      importarferiadosagenda.this.AV11error = GXv_char2[0] ;
      if ( (GXutil.strcmp("", AV11error)==0) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.eliminarferiadosagenda(remoteHandle, context).execute( AV10PaiCod, AV8anio) ;
         new web.grabarferiadosdesdejson(remoteHandle, context).execute( AV10PaiCod, AV8anio, AV9json) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = importarferiadosagenda.this.AV11error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11error = "" ;
      AV9json = "" ;
      GXv_char1 = new String[1] ;
      GXv_char2 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10PaiCod ;
   private short AV8anio ;
   private short Gx_err ;
   private String GXv_char1[] ;
   private String GXv_char2[] ;
   private boolean Cond_result ;
   private String AV9json ;
   private String AV11error ;
   private String[] aP2 ;
}

