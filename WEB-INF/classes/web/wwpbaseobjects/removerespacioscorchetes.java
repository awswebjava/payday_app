package web.wwpbaseobjects ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class removerespacioscorchetes extends GXProcedure
{
   public removerespacioscorchetes( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( removerespacioscorchetes.class ), "" );
   }

   public removerespacioscorchetes( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( )
   {
      removerespacioscorchetes.this.aP0 = new String[] {""};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( String[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( String[] aP0 )
   {
      removerespacioscorchetes.this.AV8FormulaAux = aP0[0];
      this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8FormulaAux = GXutil.strReplace( AV8FormulaAux, "[ ", "[") ;
      AV8FormulaAux = GXutil.strReplace( AV8FormulaAux, " ]", "]") ;
      AV8FormulaAux = GXutil.strReplace( AV8FormulaAux, "{ ", "{") ;
      AV8FormulaAux = GXutil.strReplace( AV8FormulaAux, " }", "}") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = removerespacioscorchetes.this.AV8FormulaAux;
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
   private String AV8FormulaAux ;
   private String[] aP0 ;
}
