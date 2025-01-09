package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class convertircalculomayus extends GXProcedure
{
   public convertircalculomayus( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( convertircalculomayus.class ), "" );
   }

   public convertircalculomayus( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      convertircalculomayus.this.aP1 = new String[] {""};
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
      convertircalculomayus.this.AV9operando = aP0;
      convertircalculomayus.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV10operandoPalabra = AV9operando ;
      AV8OpeCodForMay = GXutil.trim( GXutil.upper( AV10operandoPalabra)) ;
      GXv_char1[0] = AV8OpeCodForMay ;
      new web.removercorchetes(remoteHandle, context).execute( GXv_char1) ;
      convertircalculomayus.this.AV8OpeCodForMay = GXv_char1[0] ;
      AV8OpeCodForMay = GXutil.strReplace( AV8OpeCodForMay, " X", "") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = convertircalculomayus.this.AV8OpeCodForMay;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8OpeCodForMay = "" ;
      AV10operandoPalabra = "" ;
      GXv_char1 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV9operando ;
   private String AV8OpeCodForMay ;
   private String AV10operandoPalabra ;
   private String GXv_char1[] ;
   private String[] aP1 ;
}

