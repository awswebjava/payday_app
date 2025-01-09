package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gettipodetarifa extends GXProcedure
{
   public gettipodetarifa( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gettipodetarifa.class ), "" );
   }

   public gettipodetarifa( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             short aP4 ,
                             String aP5 ,
                             String aP6 )
   {
      gettipodetarifa.this.aP7 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        short aP4 ,
                        String aP5 ,
                        String aP6 ,
                        String[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             short aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String[] aP7 )
   {
      gettipodetarifa.this.AV8CliCod = aP0;
      gettipodetarifa.this.AV15EmpCod = aP1;
      gettipodetarifa.this.AV22LiqNro = aP2;
      gettipodetarifa.this.AV17LegNumero = aP3;
      gettipodetarifa.this.AV21parmCliPaiConve = aP4;
      gettipodetarifa.this.AV20parmCliConvenio = aP5;
      gettipodetarifa.this.AV19parmCatCodigo = aP6;
      gettipodetarifa.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( ! (GXutil.strcmp("", AV20parmCliConvenio)==0) && ! (GXutil.strcmp("", AV19parmCatCodigo)==0) )
      {
         AV9CliPaiConve = AV21parmCliPaiConve ;
         AV10CliConvenio = AV20parmCliConvenio ;
         AV11CatCodigo = AV19parmCatCodigo ;
      }
      else
      {
         GXv_char1[0] = AV11CatCodigo ;
         GXv_char2[0] = AV10CliConvenio ;
         new web.obtcategorialegajo(remoteHandle, context).execute( AV8CliCod, AV15EmpCod, AV22LiqNro, AV17LegNumero, GXv_char1, GXv_char2) ;
         gettipodetarifa.this.AV11CatCodigo = GXv_char1[0] ;
         gettipodetarifa.this.AV10CliConvenio = GXv_char2[0] ;
         if ( ! (GXutil.strcmp("", AV11CatCodigo)==0) )
         {
            /* Execute user subroutine: 'PAIS' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      if ( ! (GXutil.strcmp("", AV11CatCodigo)==0) )
      {
         GXv_int3[0] = AV26auxCliPaiConve ;
         new web.getpaisdeconvenio(remoteHandle, context).execute( AV10CliConvenio, AV9CliPaiConve, GXv_int3) ;
         gettipodetarifa.this.AV26auxCliPaiConve = GXv_int3[0] ;
         GXv_char2[0] = AV13tipo_tarifa ;
         new web.gettipotarifacat(remoteHandle, context).execute( AV8CliCod, AV26auxCliPaiConve, AV10CliConvenio, AV11CatCodigo, GXv_char2) ;
         gettipodetarifa.this.AV13tipo_tarifa = GXv_char2[0] ;
      }
      else
      {
         GXv_char2[0] = AV13tipo_tarifa ;
         new web.getlegtipotarifa(remoteHandle, context).execute( AV8CliCod, AV15EmpCod, AV17LegNumero, GXv_char2) ;
         gettipodetarifa.this.AV13tipo_tarifa = GXv_char2[0] ;
         if ( (GXutil.strcmp("", AV13tipo_tarifa)==0) )
         {
            AV13tipo_tarifa = "P" ;
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'PAIS' Routine */
      returnInSub = false ;
      if ( (0==AV21parmCliPaiConve) )
      {
         GXv_int3[0] = AV9CliPaiConve ;
         new web.getlegpaicod(remoteHandle, context).execute( AV8CliCod, AV15EmpCod, AV17LegNumero, GXv_int3) ;
         gettipodetarifa.this.AV9CliPaiConve = GXv_int3[0] ;
      }
      else
      {
         AV9CliPaiConve = AV21parmCliPaiConve ;
      }
   }

   protected void cleanup( )
   {
      this.aP7[0] = gettipodetarifa.this.AV13tipo_tarifa;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13tipo_tarifa = "" ;
      AV10CliConvenio = "" ;
      AV11CatCodigo = "" ;
      GXv_char1 = new String[1] ;
      GXv_char2 = new String[1] ;
      GXv_int3 = new short[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV15EmpCod ;
   private short AV21parmCliPaiConve ;
   private short AV9CliPaiConve ;
   private short AV26auxCliPaiConve ;
   private short GXv_int3[] ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV22LiqNro ;
   private int AV17LegNumero ;
   private String AV20parmCliConvenio ;
   private String AV19parmCatCodigo ;
   private String AV13tipo_tarifa ;
   private String AV10CliConvenio ;
   private String AV11CatCodigo ;
   private String GXv_char1[] ;
   private String GXv_char2[] ;
   private boolean returnInSub ;
   private String[] aP7 ;
}

