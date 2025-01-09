package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class fetchferiadosagenda extends GXProcedure
{
   public fetchferiadosagenda( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( fetchferiadosagenda.class ), "" );
   }

   public fetchferiadosagenda( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( short aP0 ,
                             String[] aP1 )
   {
      fetchferiadosagenda.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( short aP0 ,
                        String[] aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( short aP0 ,
                             String[] aP1 ,
                             String[] aP2 )
   {
      fetchferiadosagenda.this.AV8anio = aP0;
      fetchferiadosagenda.this.aP1 = aP1;
      fetchferiadosagenda.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV9json ;
      GXv_char2[0] = AV10error ;
      new web.json_desdearchivo(remoteHandle, context).execute( localUtil.ymdtod( AV8anio, 1, 1), httpContext.getMessage( "FERIADOS", ""), GXv_char1, GXv_char2) ;
      fetchferiadosagenda.this.AV9json = GXv_char1[0] ;
      fetchferiadosagenda.this.AV10error = GXv_char2[0] ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = fetchferiadosagenda.this.AV9json;
      this.aP2[0] = fetchferiadosagenda.this.AV10error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9json = "" ;
      AV10error = "" ;
      GXv_char1 = new String[1] ;
      GXv_char2 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8anio ;
   private short Gx_err ;
   private String GXv_char1[] ;
   private String GXv_char2[] ;
   private String AV9json ;
   private String AV10error ;
   private String[] aP2 ;
   private String[] aP1 ;
}

