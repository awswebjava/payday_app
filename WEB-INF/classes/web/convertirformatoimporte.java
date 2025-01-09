package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class convertirformatoimporte extends GXProcedure
{
   public convertirformatoimporte( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( convertirformatoimporte.class ), "" );
   }

   public convertirformatoimporte( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 )
   {
      convertirformatoimporte.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String[] aP2 )
   {
      convertirformatoimporte.this.AV10in_valor = aP0;
      convertirformatoimporte.this.AV11formatoPalabra = aP1;
      convertirformatoimporte.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( GXutil.strcmp(AV11formatoPalabra, httpContext.getMessage( "Miles_Punto", "")) == 0 )
      {
         AV9out_valor = GXutil.strReplace( AV10in_valor, ".", "") ;
         AV9out_valor = GXutil.strReplace( AV9out_valor, ",", ".") ;
      }
      else
      {
         AV9out_valor = GxRegex.Replace(AV10in_valor,",","") ;
         AV9out_valor = GXutil.strReplace( AV9out_valor, ".", ",") ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = convertirformatoimporte.this.AV9out_valor;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9out_valor = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV10in_valor ;
   private String AV11formatoPalabra ;
   private String AV9out_valor ;
   private String[] aP2 ;
}

