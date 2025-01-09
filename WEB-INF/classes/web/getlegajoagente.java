package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getlegajoagente extends GXProcedure
{
   public getlegajoagente( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getlegajoagente.class ), "" );
   }

   public getlegajoagente( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 )
   {
      getlegajoagente.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String[] aP3 )
   {
      getlegajoagente.this.AV10CliCod = aP0;
      getlegajoagente.this.AV9EmpCod = aP1;
      getlegajoagente.this.AV8LegNumero = aP2;
      getlegajoagente.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_boolean1[0] = AV11LegAgenReten ;
      new web.getlegagenreten(remoteHandle, context).execute( AV10CliCod, AV9EmpCod, AV8LegNumero, GXv_boolean1) ;
      getlegajoagente.this.AV11LegAgenReten = GXv_boolean1[0] ;
      if ( AV11LegAgenReten )
      {
         AV12valor = "1" ;
      }
      else
      {
         AV12valor = "0" ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getlegajoagente.this.AV12valor;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12valor = "" ;
      GXv_boolean1 = new boolean[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV8LegNumero ;
   private String AV12valor ;
   private boolean AV11LegAgenReten ;
   private boolean GXv_boolean1[] ;
   private String[] aP3 ;
}

