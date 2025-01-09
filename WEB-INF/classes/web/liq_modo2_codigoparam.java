package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class liq_modo2_codigoparam extends GXProcedure
{
   public liq_modo2_codigoparam( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liq_modo2_codigoparam.class ), "" );
   }

   public liq_modo2_codigoparam( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      liq_modo2_codigoparam.this.aP1 = new String[] {""};
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
      liq_modo2_codigoparam.this.AV9liq_modo = aP0;
      liq_modo2_codigoparam.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8parmcod = AV9liq_modo ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = liq_modo2_codigoparam.this.AV8parmcod;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8parmcod = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV9liq_modo ;
   private String AV8parmcod ;
   private String[] aP1 ;
}

