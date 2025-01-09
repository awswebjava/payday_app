package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class warningmigrfaltadato extends GXProcedure
{
   public warningmigrfaltadato( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( warningmigrfaltadato.class ), "" );
   }

   public warningmigrfaltadato( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      warningmigrfaltadato.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             String[] aP1 )
   {
      warningmigrfaltadato.this.AV8que = aP0;
      warningmigrfaltadato.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9Texto = httpContext.getMessage( "Falta el dato de ", "") + GXutil.trim( AV8que) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = warningmigrfaltadato.this.AV9Texto;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9Texto = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8que ;
   private String AV9Texto ;
   private String[] aP1 ;
}

