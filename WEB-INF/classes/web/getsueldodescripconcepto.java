package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getsueldodescripconcepto extends GXProcedure
{
   public getsueldodescripconcepto( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getsueldodescripconcepto.class ), "" );
   }

   public getsueldodescripconcepto( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 )
   {
      getsueldodescripconcepto.this.aP1 = new String[] {""};
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
      getsueldodescripconcepto.this.AV10CliCod = aP0;
      getsueldodescripconcepto.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8sueldoDescrip = httpContext.getMessage( "SUELDO BÁSICO", "") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getsueldodescripconcepto.this.AV8sueldoDescrip;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8sueldoDescrip = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV10CliCod ;
   private String AV8sueldoDescrip ;
   private String[] aP1 ;
}

