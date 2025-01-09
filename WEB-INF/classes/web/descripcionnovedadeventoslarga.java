package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class descripcionnovedadeventoslarga extends GXProcedure
{
   public descripcionnovedadeventoslarga( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( descripcionnovedadeventoslarga.class ), "" );
   }

   public descripcionnovedadeventoslarga( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 )
   {
      descripcionnovedadeventoslarga.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             String[] aP1 )
   {
      descripcionnovedadeventoslarga.this.AV9CliCod = aP0;
      descripcionnovedadeventoslarga.this.AV8Descripcion = aP1[0];
      this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV8Descripcion ;
      GXv_char2[0] = GXt_char1 ;
      new web.descripcionnovedadeventos(remoteHandle, context).execute( AV9CliCod, GXv_char2) ;
      descripcionnovedadeventoslarga.this.GXt_char1 = GXv_char2[0] ;
      AV8Descripcion = GXt_char1 ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = descripcionnovedadeventoslarga.this.AV8Descripcion;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9CliCod ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String AV8Descripcion ;
   private String[] aP1 ;
}

