package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class iniopecliente extends GXProcedure
{
   public iniopecliente( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( iniopecliente.class ), "" );
   }

   public iniopecliente( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( int aP0 )
   {
      iniopecliente.this.AV9CliCod = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV20primeroDeEnero2022 = localUtil.ymdtod( 2022, 1, 1) ;
      AV22i = (short)(1) ;
      AV21periodos.add(AV20primeroDeEnero2022, 0);
      AV24marzoDate = localUtil.ymdtod( 2022, 3, 1) ;
      AV21periodos.add(AV24marzoDate, 0);
      AV23junio = localUtil.ymdtod( 2022, 6, 1) ;
      AV21periodos.add(AV23junio, 0);
      AV28julio = localUtil.ymdtod( 2022, 7, 1) ;
      AV21periodos.add(AV28julio, 0);
      AV25septiembreDate = localUtil.ymdtod( 2022, 9, 1) ;
      AV21periodos.add(AV25septiembreDate, 0);
      AV27noviembreDate = localUtil.ymdtod( 2022, 11, 1) ;
      AV21periodos.add(AV27noviembreDate, 0);
      AV26diciembreDate = localUtil.ymdtod( 2022, 12, 1) ;
      AV21periodos.add(AV26diciembreDate, 0);
      AV29enero2023 = localUtil.ymdtod( 2023, 1, 1) ;
      AV21periodos.add(AV29enero2023, 0);
      AV30febrero2023 = localUtil.ymdtod( 2023, 2, 1) ;
      AV21periodos.add(AV30febrero2023, 0);
      AV31marzo2023 = localUtil.ymdtod( 2023, 3, 1) ;
      AV21periodos.add(AV31marzo2023, 0);
      AV35abril2023 = localUtil.ymdtod( 2023, 4, 1) ;
      AV21periodos.add(AV35abril2023, 0);
      AV34mayo2023 = localUtil.ymdtod( 2023, 5, 1) ;
      AV21periodos.add(AV34mayo2023, 0);
      AV37junio2023 = localUtil.ymdtod( 2023, 6, 1) ;
      AV21periodos.add(AV37junio2023, 0);
      AV45julio2023 = localUtil.ymdtod( 2023, 7, 1) ;
      AV21periodos.add(AV45julio2023, 0);
      AV42agosto2023 = localUtil.ymdtod( 2023, 8, 1) ;
      AV21periodos.add(AV42agosto2023, 0);
      AV48septiembre2023 = localUtil.ymdtod( 2023, 9, 1) ;
      AV21periodos.add(AV48septiembre2023, 0);
      AV47octubre2023 = localUtil.ymdtod( 2023, 10, 1) ;
      AV21periodos.add(AV47octubre2023, 0);
      AV46noviembre2023 = localUtil.ymdtod( 2023, 11, 1) ;
      AV21periodos.add(AV46noviembre2023, 0);
      AV43diciembre2023 = localUtil.ymdtod( 2023, 12, 1) ;
      AV21periodos.add(AV43diciembre2023, 0);
      AV44enero2024 = localUtil.ymdtod( 2024, 1, 1) ;
      AV21periodos.add(AV44enero2024, 0);
      AV51febrer2024 = localUtil.ymdtod( 2024, 2, 1) ;
      AV21periodos.add(AV51febrer2024, 0);
      AV50marzo2024 = localUtil.ymdtod( 2024, 3, 1) ;
      AV21periodos.add(AV50marzo2024, 0);
      AV52abril2024 = localUtil.ymdtod( 2024, 4, 1) ;
      AV21periodos.add(AV52abril2024, 0);
      AV53mayo2024 = localUtil.ymdtod( 2024, 5, 1) ;
      AV21periodos.add(AV53mayo2024, 0);
      AV54junio2024 = localUtil.ymdtod( 2024, 6, 1) ;
      AV21periodos.add(AV54junio2024, 0);
      AV55julio2024 = localUtil.ymdtod( 2024, 7, 1) ;
      AV21periodos.add(AV55julio2024, 0);
      /* Execute user subroutine: 'TRAMOS GANANCIAS 2022' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      /* Execute user subroutine: 'TRAMOS GANANCIAS 2024 NUEVA' */
      S131 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      while ( AV22i <= AV21periodos.size() )
      {
         AV59GXV2 = 1 ;
         AV58GXV1 = web.gxdomainconstantes_default.getValues() ;
         while ( AV59GXV2 <= AV58GXV1.size() )
         {
            AV10constante = (String)AV58GXV1.elementAt(-1+AV59GXV2) ;
            AV14OpeCliValor = "" ;
            AV32OpeCliEsCant = false ;
            AV33OpeCliAliEs = false ;
            if ( GXutil.strcmp(AV10constante, "[gan_escala]") == 0 )
            {
               if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV20primeroDeEnero2022)) )
               {
                  AV14OpeCliValor = AV16tasas_y_tramos_de_escala.toJSonString(false) ;
               }
               else
               {
                  if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV29enero2023)) )
                  {
                     AV60GXV3 = 1 ;
                     while ( AV60GXV3 <= AV16tasas_y_tramos_de_escala.size() )
                     {
                        AV17tramo = (web.Sdttasas_y_tramos_de_escala_tramo)((web.Sdttasas_y_tramos_de_escala_tramo)AV16tasas_y_tramos_de_escala.elementAt(-1+AV60GXV3));
                        if ( DecimalUtil.compareTo(AV17tramo.getgxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta(), DecimalUtil.stringToDec("99999999999.99")) != 0 )
                        {
                           AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta( AV17tramo.getgxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta().multiply(DecimalUtil.stringToDec("1.7884")) );
                        }
                        AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Importe( AV17tramo.getgxTv_Sdttasas_y_tramos_de_escala_tramo_Importe().multiply(DecimalUtil.stringToDec("1.7884")) );
                        AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Resto( AV17tramo.getgxTv_Sdttasas_y_tramos_de_escala_tramo_Resto().multiply(DecimalUtil.stringToDec("1.7884")) );
                        AV60GXV3 = (int)(AV60GXV3+1) ;
                     }
                     AV14OpeCliValor = AV16tasas_y_tramos_de_escala.toJSonString(false) ;
                  }
                  else
                  {
                     if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV44enero2024)) )
                     {
                        AV14OpeCliValor = AV49tasas_y_tramos_de_escala_2024.toJSonString(false) ;
                     }
                  }
               }
            }
            else if ( GXutil.strcmp(AV10constante, "[fijo_ART]") == 0 )
            {
               if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV20primeroDeEnero2022)) )
               {
                  AV14OpeCliValor = "141" ;
               }
               else
               {
                  if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV46noviembre2023)) )
                  {
                     AV14OpeCliValor = "342" ;
                  }
                  else
                  {
                     if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV44enero2024)) )
                     {
                        AV14OpeCliValor = "418" ;
                     }
                     else
                     {
                        if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV51febrer2024)) )
                        {
                           AV14OpeCliValor = "444" ;
                        }
                        else
                        {
                           if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV50marzo2024)) )
                           {
                              AV14OpeCliValor = "481" ;
                           }
                           else
                           {
                              if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV52abril2024)) )
                              {
                                 AV14OpeCliValor = "552" ;
                              }
                              else
                              {
                                 if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV53mayo2024)) )
                                 {
                                    AV14OpeCliValor = "615" ;
                                 }
                                 else
                                 {
                                    if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV54junio2024)) )
                                    {
                                       AV14OpeCliValor = "702" ;
                                    }
                                    else
                                    {
                                       if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV55julio2024)) )
                                       {
                                          AV14OpeCliValor = "815" ;
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
            else if ( ( GXutil.strcmp(AV10constante, "[alicuota_donaciones]") == 0 ) && GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV20primeroDeEnero2022)) )
            {
               AV14OpeCliValor = "0.05" ;
               AV33OpeCliAliEs = true ;
            }
            else if ( ( GXutil.strcmp(AV10constante, "[limite_medicos]") == 0 ) && GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV20primeroDeEnero2022)) )
            {
               AV14OpeCliValor = "0.05" ;
               AV33OpeCliAliEs = true ;
            }
            else if ( ( GXutil.strcmp(AV10constante, "[limite_prepaga]") == 0 ) && GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV20primeroDeEnero2022)) )
            {
               AV14OpeCliValor = "0.05" ;
               AV33OpeCliAliEs = true ;
            }
            else if ( GXutil.strcmp(AV10constante, "[ded_especial]") == 0 )
            {
               if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV20primeroDeEnero2022)) )
               {
                  AV14OpeCliValor = "1212311.24" ;
               }
               else
               {
                  if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV29enero2023)) )
                  {
                     AV14OpeCliValor = "2168079.35" ;
                  }
                  else
                  {
                     if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV44enero2024)) )
                     {
                        AV14OpeCliValor = "14836968" ;
                     }
                  }
               }
            }
            else if ( GXutil.strcmp(AV10constante, "[mni]") == 0 )
            {
               if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV20primeroDeEnero2022)) )
               {
                  AV14OpeCliValor = "252564.84" ;
               }
               else
               {
                  if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV29enero2023)) )
                  {
                     AV14OpeCliValor = "451683.19" ;
                  }
                  else
                  {
                     if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV44enero2024)) )
                     {
                        AV14OpeCliValor = "3091035" ;
                     }
                  }
               }
            }
            else if ( GXutil.strcmp(AV10constante, "[ded_hijo]") == 0 )
            {
               if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV20primeroDeEnero2022)) )
               {
                  AV14OpeCliValor = "118741.97" ;
               }
               else
               {
                  if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV29enero2023)) )
                  {
                     AV14OpeCliValor = "212356.37" ;
                  }
                  else
                  {
                     if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV44enero2024)) )
                     {
                        AV14OpeCliValor = "1468096" ;
                     }
                  }
               }
            }
            else if ( GXutil.strcmp(AV10constante, "[ded_hijo_incap]") == 0 )
            {
               if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV20primeroDeEnero2022)) )
               {
                  AV14OpeCliValor = "237483.94" ;
               }
               else
               {
                  if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV29enero2023)) )
                  {
                     AV14OpeCliValor = "424712.74" ;
                  }
                  else
                  {
                     if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV44enero2024)) )
                     {
                        AV14OpeCliValor = "2936192" ;
                     }
                  }
               }
            }
            else if ( ( GXutil.strcmp(AV10constante, "[tope_hipoteca]") == 0 ) && ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV20primeroDeEnero2022)) || GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV29enero2023)) || GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV44enero2024)) ) )
            {
               AV14OpeCliValor = "20000" ;
            }
            else if ( GXutil.strcmp(AV10constante, "[ded_cony]") == 0 )
            {
               if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV20primeroDeEnero2022)) )
               {
                  AV14OpeCliValor = "235457.25" ;
               }
               else
               {
                  if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV29enero2023)) )
                  {
                     AV14OpeCliValor = "421088.24" ;
                  }
                  else
                  {
                     if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV44enero2024)) )
                     {
                        AV14OpeCliValor = "2911135" ;
                     }
                  }
               }
            }
            else if ( ( GXutil.strcmp(AV10constante, "[tope_sepelio]") == 0 ) && ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV20primeroDeEnero2022)) || GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV44enero2024)) || GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV44enero2024)) ) )
            {
               AV14OpeCliValor = "996.23" ;
            }
            else if ( ( GXutil.strcmp(AV10constante, "[tope_seguros]") == 0 ) && ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV20primeroDeEnero2022)) || GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV44enero2024)) || GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV44enero2024)) ) )
            {
               AV14OpeCliValor = "42921.24" ;
            }
            else if ( ( GXutil.strcmp(AV10constante, "[horas_noct]") == 0 ) && GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV20primeroDeEnero2022)) )
            {
               AV14OpeCliValor = "1.33" ;
               AV33OpeCliAliEs = true ;
            }
            else if ( ( GXutil.strcmp(AV10constante, "[apo_jub_ali]") == 0 ) && GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV20primeroDeEnero2022)) )
            {
               AV14OpeCliValor = "0.11" ;
               AV32OpeCliEsCant = true ;
               AV33OpeCliAliEs = true ;
            }
            else if ( ( GXutil.strcmp(AV10constante, "[apo_INSSJyP_ali]") == 0 ) && GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV20primeroDeEnero2022)) )
            {
               AV14OpeCliValor = "0.03" ;
               AV32OpeCliEsCant = true ;
               AV33OpeCliAliEs = true ;
            }
            else if ( ( GXutil.strcmp(AV10constante, "[apo_OS_ali]") == 0 ) && GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV20primeroDeEnero2022)) )
            {
               AV14OpeCliValor = "0.03" ;
               AV32OpeCliEsCant = true ;
               AV33OpeCliAliEs = true ;
            }
            else if ( ( GXutil.strcmp(AV10constante, "[apo_OS_adh_ali]") == 0 ) && GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV20primeroDeEnero2022)) )
            {
               AV14OpeCliValor = "0.015" ;
               AV32OpeCliEsCant = true ;
               AV33OpeCliAliEs = true ;
            }
            else if ( GXutil.strcmp(AV10constante, "[smvm]") == 0 )
            {
               if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV20primeroDeEnero2022)) )
               {
                  AV14OpeCliValor = "54550" ;
               }
               else
               {
                  if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV29enero2023)) )
                  {
                     AV14OpeCliValor = "65427" ;
                  }
                  else
                  {
                     if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV30febrero2023)) )
                     {
                        AV14OpeCliValor = "67743" ;
                     }
                     else
                     {
                        if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV31marzo2023)) )
                        {
                           AV14OpeCliValor = "69500" ;
                        }
                        else
                        {
                           if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV35abril2023)) )
                           {
                              AV14OpeCliValor = "80342" ;
                           }
                           else
                           {
                              if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV34mayo2023)) )
                              {
                                 AV14OpeCliValor = "84512" ;
                              }
                              else
                              {
                                 if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV37junio2023)) )
                                 {
                                    AV14OpeCliValor = "87987" ;
                                 }
                                 else
                                 {
                                    if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV45julio2023)) )
                                    {
                                       AV14OpeCliValor = "105500" ;
                                    }
                                    else
                                    {
                                       if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV42agosto2023)) )
                                       {
                                          AV14OpeCliValor = "112500" ;
                                       }
                                       else
                                       {
                                          if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV48septiembre2023)) )
                                          {
                                             AV14OpeCliValor = "118000" ;
                                          }
                                          else
                                          {
                                             if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV47octubre2023)) )
                                             {
                                                AV14OpeCliValor = "132000" ;
                                             }
                                             else
                                             {
                                                if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV46noviembre2023)) )
                                                {
                                                   AV14OpeCliValor = "146000" ;
                                                }
                                                else
                                                {
                                                   if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV43diciembre2023)) )
                                                   {
                                                      AV14OpeCliValor = "156000" ;
                                                   }
                                                   else
                                                   {
                                                      if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV44enero2024)) )
                                                      {
                                                         AV14OpeCliValor = "156000" ;
                                                      }
                                                      else
                                                      {
                                                         if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV51febrer2024)) )
                                                         {
                                                            AV14OpeCliValor = "180000" ;
                                                         }
                                                         else
                                                         {
                                                            if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV50marzo2024)) )
                                                            {
                                                               AV14OpeCliValor = "202800" ;
                                                            }
                                                            else
                                                            {
                                                               if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV52abril2024)) )
                                                               {
                                                                  AV14OpeCliValor = "221052" ;
                                                               }
                                                               else
                                                               {
                                                                  if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV53mayo2024)) )
                                                                  {
                                                                     AV14OpeCliValor = "234315.12" ;
                                                                  }
                                                               }
                                                            }
                                                         }
                                                      }
                                                   }
                                                }
                                             }
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
            else if ( ( GXutil.strcmp(AV10constante, "[ley_27541_ali]") == 0 ) && GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV20primeroDeEnero2022)) )
            {
               AV41ley_27541_ali.setgxTv_Sdtley_27541_ali_Jubilacion_a( DecimalUtil.stringToDec("0.1235") );
               AV41ley_27541_ali.setgxTv_Sdtley_27541_ali_Jubilacion_b( DecimalUtil.stringToDec("0.1077") );
               AV41ley_27541_ali.setgxTv_Sdtley_27541_ali_Inssjyp_a( DecimalUtil.stringToDec("0.0158") );
               AV41ley_27541_ali.setgxTv_Sdtley_27541_ali_Inssjyp_b( DecimalUtil.stringToDec("0.0159") );
               AV41ley_27541_ali.setgxTv_Sdtley_27541_ali_Fne_a( DecimalUtil.stringToDec("0.0107") );
               AV41ley_27541_ali.setgxTv_Sdtley_27541_ali_Fne_b( DecimalUtil.stringToDec("0.0094") );
               AV41ley_27541_ali.setgxTv_Sdtley_27541_ali_Aaff_a( DecimalUtil.stringToDec("0.0540") );
               AV41ley_27541_ali.setgxTv_Sdtley_27541_ali_Aaff_b( DecimalUtil.stringToDec("0.0470") );
               AV14OpeCliValor = AV41ley_27541_ali.toJSonString(false, true) ;
               AV33OpeCliAliEs = true ;
            }
            else if ( ( GXutil.strcmp(AV10constante, "[contr_OS_FSR_ali]") == 0 ) && GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV20primeroDeEnero2022)) )
            {
               AV14OpeCliValor = "0.06" ;
               AV32OpeCliEsCant = true ;
               AV33OpeCliAliEs = true ;
            }
            else if ( ( GXutil.strcmp(AV10constante, "[distr_OS_ali]") == 0 ) && GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV20primeroDeEnero2022)) )
            {
               AV40pctOSItem = (web.Sdtpct_os_fsr_pct_os_fsrItem)new web.Sdtpct_os_fsr_pct_os_fsrItem(remoteHandle, context);
               AV40pctOSItem.setgxTv_Sdtpct_os_fsr_pct_os_fsrItem_Enconvenio( false );
               AV40pctOSItem.setgxTv_Sdtpct_os_fsr_pct_os_fsrItem_Remuneraciondesde( DecimalUtil.doubleToDec(0) );
               AV40pctOSItem.setgxTv_Sdtpct_os_fsr_pct_os_fsrItem_Remuneracionhasta( DecimalUtil.stringToDec("2399.99") );
               AV40pctOSItem.setgxTv_Sdtpct_os_fsr_pct_os_fsrItem_Alicuota( DecimalUtil.stringToDec("0.85") );
               AV38pct_os_fsr.add(AV40pctOSItem, 0);
               AV40pctOSItem = (web.Sdtpct_os_fsr_pct_os_fsrItem)new web.Sdtpct_os_fsr_pct_os_fsrItem(remoteHandle, context);
               AV40pctOSItem.setgxTv_Sdtpct_os_fsr_pct_os_fsrItem_Enconvenio( false );
               AV40pctOSItem.setgxTv_Sdtpct_os_fsr_pct_os_fsrItem_Remuneraciondesde( DecimalUtil.doubleToDec(2400) );
               AV40pctOSItem.setgxTv_Sdtpct_os_fsr_pct_os_fsrItem_Remuneracionhasta( DecimalUtil.doubleToDec(0) );
               AV40pctOSItem.setgxTv_Sdtpct_os_fsr_pct_os_fsrItem_Alicuota( DecimalUtil.stringToDec("0.8") );
               AV38pct_os_fsr.add(AV40pctOSItem, 0);
               AV40pctOSItem = (web.Sdtpct_os_fsr_pct_os_fsrItem)new web.Sdtpct_os_fsr_pct_os_fsrItem(remoteHandle, context);
               AV40pctOSItem.setgxTv_Sdtpct_os_fsr_pct_os_fsrItem_Enconvenio( true );
               AV40pctOSItem.setgxTv_Sdtpct_os_fsr_pct_os_fsrItem_Remuneraciondesde( DecimalUtil.doubleToDec(0) );
               AV40pctOSItem.setgxTv_Sdtpct_os_fsr_pct_os_fsrItem_Remuneracionhasta( DecimalUtil.stringToDec("2399.99") );
               AV40pctOSItem.setgxTv_Sdtpct_os_fsr_pct_os_fsrItem_Alicuota( DecimalUtil.stringToDec("0.9") );
               AV38pct_os_fsr.add(AV40pctOSItem, 0);
               AV40pctOSItem = (web.Sdtpct_os_fsr_pct_os_fsrItem)new web.Sdtpct_os_fsr_pct_os_fsrItem(remoteHandle, context);
               AV40pctOSItem.setgxTv_Sdtpct_os_fsr_pct_os_fsrItem_Enconvenio( true );
               AV40pctOSItem.setgxTv_Sdtpct_os_fsr_pct_os_fsrItem_Remuneraciondesde( DecimalUtil.doubleToDec(2400) );
               AV40pctOSItem.setgxTv_Sdtpct_os_fsr_pct_os_fsrItem_Remuneracionhasta( DecimalUtil.doubleToDec(0) );
               AV40pctOSItem.setgxTv_Sdtpct_os_fsr_pct_os_fsrItem_Alicuota( DecimalUtil.stringToDec("0.85") );
               AV38pct_os_fsr.add(AV40pctOSItem, 0);
               AV14OpeCliValor = AV38pct_os_fsr.toJSonString(false) ;
               AV32OpeCliEsCant = true ;
               AV33OpeCliAliEs = true ;
            }
            else if ( GXutil.strcmp(AV10constante, "[svc_Fijo]") == 0 )
            {
               AV32OpeCliEsCant = false ;
               AV33OpeCliAliEs = false ;
               if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV20primeroDeEnero2022)) || GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV29enero2023)) )
               {
                  AV14OpeCliValor = "78.36" ;
               }
               else
               {
                  if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV44enero2024)) )
                  {
                     AV14OpeCliValor = "175.89" ;
                  }
               }
            }
            else if ( GXutil.strcmp(AV10constante, "[base_imp_min]") == 0 )
            {
               if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV24marzoDate)) )
               {
                  AV14OpeCliValor = "10989.91" ;
               }
               else
               {
                  if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV23junio)) )
                  {
                     AV14OpeCliValor = "12638.40" ;
                  }
                  else
                  {
                     if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV25septiembreDate)) )
                     {
                        AV14OpeCliValor = "14601.14" ;
                     }
                     else
                     {
                        if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV26diciembreDate)) )
                        {
                           AV14OpeCliValor = "16881.84" ;
                        }
                        else
                        {
                           if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV31marzo2023)) )
                           {
                              AV14OpeCliValor = "19758.51" ;
                           }
                           else
                           {
                              if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV37junio2023)) )
                              {
                                 AV14OpeCliValor = "23891.99" ;
                              }
                              else
                              {
                                 if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV48septiembre2023)) )
                                 {
                                    AV14OpeCliValor = "29456.43" ;
                                 }
                                 else
                                 {
                                    if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV43diciembre2023)) )
                                    {
                                       AV14OpeCliValor = "35603.99" ;
                                    }
                                    else
                                    {
                                       if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV50marzo2024)) )
                                       {
                                          AV14OpeCliValor = "45281.15" ;
                                       }
                                       else
                                       {
                                          if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV54junio2024)) )
                                          {
                                             AV14OpeCliValor = "69694.36" ;
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
            else if ( GXutil.strcmp(AV10constante, "[base_imp_max]") == 0 )
            {
               if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV24marzoDate)) )
               {
                  AV14OpeCliValor = "357166.98" ;
               }
               else
               {
                  if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV23junio)) )
                  {
                     AV14OpeCliValor = "410742.03" ;
                  }
                  else
                  {
                     if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV25septiembreDate)) )
                     {
                        AV14OpeCliValor = "474530.27" ;
                     }
                     else
                     {
                        if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV26diciembreDate)) )
                        {
                           AV14OpeCliValor = "548651.90" ;
                        }
                        else
                        {
                           if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV31marzo2023)) )
                           {
                              AV14OpeCliValor = "642142.18" ;
                           }
                           else
                           {
                              if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV37junio2023)) )
                              {
                                 AV14OpeCliValor = "776478.32" ;
                              }
                              else
                              {
                                 if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV48septiembre2023)) )
                                 {
                                    AV14OpeCliValor = "957320.12" ;
                                 }
                                 else
                                 {
                                    if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV43diciembre2023)) )
                                    {
                                       AV14OpeCliValor = "1157112.83" ;
                                    }
                                    else
                                    {
                                       if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV50marzo2024)) )
                                       {
                                          AV14OpeCliValor = "1471616.10" ;
                                       }
                                       else
                                       {
                                          if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV54junio2024)) )
                                          {
                                             AV14OpeCliValor = "2265033.81" ;
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
            else if ( GXutil.strcmp(AV10constante, "[piso_ganancias_casados]") == 0 )
            {
               if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV44enero2024)) )
               {
                  AV14OpeCliValor = "2340000" ;
               }
            }
            else if ( GXutil.strcmp(AV10constante, "[piso_ganancias_solteros]") == 0 )
            {
               if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV20primeroDeEnero2022)) )
               {
                  AV14OpeCliValor = "225937" ;
               }
               else
               {
                  if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV23junio)) )
                  {
                     AV14OpeCliValor = "280792" ;
                  }
                  else
                  {
                     if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV27noviembreDate)) )
                     {
                        AV14OpeCliValor = "330000" ;
                     }
                     else
                     {
                        if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV29enero2023)) )
                        {
                           AV14OpeCliValor = "404062" ;
                        }
                        else
                        {
                           if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV34mayo2023)) )
                           {
                              AV14OpeCliValor = "506230" ;
                           }
                           else
                           {
                              if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV42agosto2023)) )
                              {
                                 AV14OpeCliValor = "700870" ;
                              }
                              else
                              {
                                 if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV47octubre2023)) )
                                 {
                                    AV14OpeCliValor = "1980000" ;
                                 }
                                 else
                                 {
                                    if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV44enero2024)) )
                                    {
                                       AV14OpeCliValor = "1500000" ;
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
            else if ( GXutil.strcmp(AV10constante, "[piso_ganancias_SAC]") == 0 )
            {
               if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV20primeroDeEnero2022)) )
               {
                  AV14OpeCliValor = "280792" ;
               }
               else
               {
                  if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV28julio)) )
                  {
                     AV14OpeCliValor = "330000" ;
                  }
                  else
                  {
                     if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV29enero2023)) )
                     {
                        AV14OpeCliValor = "466017" ;
                     }
                     else
                     {
                        if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV47octubre2023)) )
                        {
                           AV14OpeCliValor = "1980000" ;
                        }
                        else
                        {
                           if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV44enero2024)) )
                           {
                              AV14OpeCliValor = "974516" ;
                           }
                        }
                     }
                  }
               }
            }
            else if ( GXutil.strcmp(AV10constante, "[tope_bonos]") == 0 )
            {
               if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV20primeroDeEnero2022)) )
               {
                  AV14OpeCliValor = "451873" ;
               }
               else
               {
                  if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV29enero2023)) )
                  {
                     AV14OpeCliValor = "808124.73" ;
                  }
                  else
                  {
                     if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV44enero2024)) )
                     {
                        AV14OpeCliValor = "2500000" ;
                     }
                  }
               }
            }
            else if ( GXutil.strcmp(AV10constante, "[ded_esp_inc_tabla]") == 0 )
            {
               if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV20primeroDeEnero2022)) )
               {
                  GXv_char1[0] = AV14OpeCliValor ;
                  GXv_char2[0] = "" ;
                  new web.json_desdearchivo(remoteHandle, context).execute( AV20primeroDeEnero2022, httpContext.getMessage( "DEI", ""), GXv_char1, GXv_char2) ;
                  iniopecliente.this.AV14OpeCliValor = GXv_char1[0] ;
               }
               else
               {
                  if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV23junio)) )
                  {
                     GXv_char2[0] = AV14OpeCliValor ;
                     GXv_char1[0] = "" ;
                     new web.json_desdearchivo(remoteHandle, context).execute( AV23junio, httpContext.getMessage( "DEI", ""), GXv_char2, GXv_char1) ;
                     iniopecliente.this.AV14OpeCliValor = GXv_char2[0] ;
                  }
                  else
                  {
                     if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV27noviembreDate)) )
                     {
                        GXv_char2[0] = AV14OpeCliValor ;
                        GXv_char1[0] = "" ;
                        new web.json_desdearchivo(remoteHandle, context).execute( AV27noviembreDate, httpContext.getMessage( "DEI", ""), GXv_char2, GXv_char1) ;
                        iniopecliente.this.AV14OpeCliValor = GXv_char2[0] ;
                     }
                     else
                     {
                        if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV29enero2023)) )
                        {
                           GXv_char2[0] = AV14OpeCliValor ;
                           GXv_char1[0] = "" ;
                           new web.json_desdearchivo(remoteHandle, context).execute( AV29enero2023, httpContext.getMessage( "DEI", ""), GXv_char2, GXv_char1) ;
                           iniopecliente.this.AV14OpeCliValor = GXv_char2[0] ;
                        }
                        else
                        {
                           if ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV34mayo2023)) )
                           {
                              GXv_char2[0] = AV14OpeCliValor ;
                              GXv_char1[0] = "" ;
                              new web.json_desdearchivo(remoteHandle, context).execute( AV34mayo2023, httpContext.getMessage( "DEI", ""), GXv_char2, GXv_char1) ;
                              iniopecliente.this.AV14OpeCliValor = GXv_char2[0] ;
                           }
                        }
                     }
                  }
               }
            }
            else if ( ( GXutil.strcmp(AV10constante, "[importe_a_detraer_default]") == 0 ) && ( GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV20primeroDeEnero2022)) || GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV29enero2023)) || GXutil.dateCompare(GXutil.resetTime((java.util.Date)AV21periodos.elementAt(-1+AV22i)), GXutil.resetTime(AV44enero2024)) ) )
            {
               AV14OpeCliValor = "7003.68" ;
            }
            else
            {
               AV14OpeCliValor = "" ;
            }
            AV13OpeCliId = GXutil.trim( AV10constante) ;
            if ( ! (GXutil.strcmp("", AV14OpeCliValor)==0) )
            {
               new web.grabaopecli2(remoteHandle, context).execute( AV9CliCod, AV13OpeCliId, "", AV13OpeCliId, httpContext.getMessage( web.gxdomainconstantes_default.getDescription(httpContext,(String)AV10constante), ""), AV14OpeCliValor, httpContext.getMessage( "NO", ""), (java.util.Date)AV21periodos.elementAt(-1+AV22i), AV36date, true, AV32OpeCliEsCant, AV33OpeCliAliEs) ;
            }
            else
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV61Pgmname, httpContext.getMessage( "asf opeclivalor vacio", "")) ;
            }
            AV59GXV2 = (int)(AV59GXV2+1) ;
         }
         new web.msgdebug7(remoteHandle, context).execute( AV61Pgmname, AV16tasas_y_tramos_de_escala.toJSonString(false)) ;
         AV22i = (short)(AV22i+1) ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'TRAMOS GANANCIAS 2022' Routine */
      returnInSub = false ;
      AV17tramo = (web.Sdttasas_y_tramos_de_escala_tramo)new web.Sdttasas_y_tramos_de_escala_tramo(remoteHandle, context);
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta( DecimalUtil.doubleToDec(97202) );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Importe( DecimalUtil.doubleToDec(0) );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Masel( DecimalUtil.stringToDec("0.05") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Resto( DecimalUtil.doubleToDec(0) );
      AV16tasas_y_tramos_de_escala.add(AV17tramo, 0);
      AV17tramo = (web.Sdttasas_y_tramos_de_escala_tramo)new web.Sdttasas_y_tramos_de_escala_tramo(remoteHandle, context);
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta( DecimalUtil.stringToDec("194404.01") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Importe( DecimalUtil.stringToDec("4860.10") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Masel( DecimalUtil.stringToDec("0.09") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Resto( DecimalUtil.stringToDec("97202.00") );
      AV16tasas_y_tramos_de_escala.add(AV17tramo, 0);
      AV17tramo = (web.Sdttasas_y_tramos_de_escala_tramo)new web.Sdttasas_y_tramos_de_escala_tramo(remoteHandle, context);
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta( DecimalUtil.stringToDec("291606.01") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Importe( DecimalUtil.stringToDec("13608.28") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Masel( DecimalUtil.stringToDec("0.12") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Resto( DecimalUtil.stringToDec("194404.01") );
      AV16tasas_y_tramos_de_escala.add(AV17tramo, 0);
      AV17tramo = (web.Sdttasas_y_tramos_de_escala_tramo)new web.Sdttasas_y_tramos_de_escala_tramo(remoteHandle, context);
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta( DecimalUtil.stringToDec("388808.02") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Importe( DecimalUtil.stringToDec("25272.52") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Masel( DecimalUtil.stringToDec("0.15") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Resto( DecimalUtil.stringToDec("291606.01") );
      AV16tasas_y_tramos_de_escala.add(AV17tramo, 0);
      AV17tramo = (web.Sdttasas_y_tramos_de_escala_tramo)new web.Sdttasas_y_tramos_de_escala_tramo(remoteHandle, context);
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta( DecimalUtil.stringToDec("583212.02") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Importe( DecimalUtil.stringToDec("39852.82") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Masel( DecimalUtil.stringToDec("0.19") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Resto( DecimalUtil.stringToDec("388808.02") );
      AV16tasas_y_tramos_de_escala.add(AV17tramo, 0);
      AV17tramo = (web.Sdttasas_y_tramos_de_escala_tramo)new web.Sdttasas_y_tramos_de_escala_tramo(remoteHandle, context);
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta( DecimalUtil.stringToDec("777616.02") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Importe( DecimalUtil.stringToDec("76789.58") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Masel( DecimalUtil.stringToDec("0.23") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Resto( DecimalUtil.stringToDec("583212.02") );
      AV16tasas_y_tramos_de_escala.add(AV17tramo, 0);
      AV17tramo = (web.Sdttasas_y_tramos_de_escala_tramo)new web.Sdttasas_y_tramos_de_escala_tramo(remoteHandle, context);
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta( DecimalUtil.stringToDec("1166424.03") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Importe( DecimalUtil.stringToDec("121502.50") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Masel( DecimalUtil.stringToDec("0.27") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Resto( DecimalUtil.stringToDec("777616.02") );
      AV16tasas_y_tramos_de_escala.add(AV17tramo, 0);
      AV17tramo = (web.Sdttasas_y_tramos_de_escala_tramo)new web.Sdttasas_y_tramos_de_escala_tramo(remoteHandle, context);
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta( DecimalUtil.stringToDec("1555232.07") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Importe( DecimalUtil.stringToDec("226480.66") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Masel( DecimalUtil.stringToDec("0.31") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Resto( DecimalUtil.stringToDec("1166424.03") );
      AV16tasas_y_tramos_de_escala.add(AV17tramo, 0);
      AV17tramo = (web.Sdttasas_y_tramos_de_escala_tramo)new web.Sdttasas_y_tramos_de_escala_tramo(remoteHandle, context);
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta( DecimalUtil.stringToDec("99999999999.99") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Importe( DecimalUtil.stringToDec("347011.16") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Masel( DecimalUtil.stringToDec("0.35") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Resto( DecimalUtil.stringToDec("1555232.07") );
      AV16tasas_y_tramos_de_escala.add(AV17tramo, 0);
   }

   public void S121( )
   {
      /* 'TRAMOS GANANCIAS 2024' Routine */
      returnInSub = false ;
      AV17tramo = (web.Sdttasas_y_tramos_de_escala_tramo)new web.Sdttasas_y_tramos_de_escala_tramo(remoteHandle, context);
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta( DecimalUtil.stringToDec("419253.95") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Importe( DecimalUtil.doubleToDec(0) );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Masel( DecimalUtil.stringToDec("0.05") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Resto( DecimalUtil.doubleToDec(0) );
      AV49tasas_y_tramos_de_escala_2024.add(AV17tramo, 0);
      AV17tramo = (web.Sdttasas_y_tramos_de_escala_tramo)new web.Sdttasas_y_tramos_de_escala_tramo(remoteHandle, context);
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta( DecimalUtil.stringToDec("838507.92") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Importe( DecimalUtil.stringToDec("20962.70") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Masel( DecimalUtil.stringToDec("0.09") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Resto( DecimalUtil.stringToDec("419253.95") );
      AV49tasas_y_tramos_de_escala_2024.add(AV17tramo, 0);
      AV17tramo = (web.Sdttasas_y_tramos_de_escala_tramo)new web.Sdttasas_y_tramos_de_escala_tramo(remoteHandle, context);
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta( DecimalUtil.stringToDec("1257761.87") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Importe( DecimalUtil.stringToDec("58695.55") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Masel( DecimalUtil.stringToDec("0.12") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Resto( DecimalUtil.stringToDec("838507.92") );
      AV49tasas_y_tramos_de_escala_2024.add(AV17tramo, 0);
      AV17tramo = (web.Sdttasas_y_tramos_de_escala_tramo)new web.Sdttasas_y_tramos_de_escala_tramo(remoteHandle, context);
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta( DecimalUtil.stringToDec("1677015.87") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Importe( DecimalUtil.stringToDec("109006.03") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Masel( DecimalUtil.stringToDec("0.15") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Resto( DecimalUtil.stringToDec("1257761.87") );
      AV49tasas_y_tramos_de_escala_2024.add(AV17tramo, 0);
      AV17tramo = (web.Sdttasas_y_tramos_de_escala_tramo)new web.Sdttasas_y_tramos_de_escala_tramo(remoteHandle, context);
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta( DecimalUtil.stringToDec("2515523.74") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Importe( DecimalUtil.stringToDec("171894.13") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Masel( DecimalUtil.stringToDec("0.19") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Resto( DecimalUtil.stringToDec("1677015.87") );
      AV49tasas_y_tramos_de_escala_2024.add(AV17tramo, 0);
      AV17tramo = (web.Sdttasas_y_tramos_de_escala_tramo)new web.Sdttasas_y_tramos_de_escala_tramo(remoteHandle, context);
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta( DecimalUtil.stringToDec("3354031.63") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Importe( DecimalUtil.stringToDec("331210.62") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Masel( DecimalUtil.stringToDec("0.23") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Resto( DecimalUtil.stringToDec("2515523.74") );
      AV49tasas_y_tramos_de_escala_2024.add(AV17tramo, 0);
      AV17tramo = (web.Sdttasas_y_tramos_de_escala_tramo)new web.Sdttasas_y_tramos_de_escala_tramo(remoteHandle, context);
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta( DecimalUtil.stringToDec("5031047.45") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Importe( DecimalUtil.stringToDec("524067.44") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Masel( DecimalUtil.stringToDec("0.27") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Resto( DecimalUtil.stringToDec("3354031.63") );
      AV49tasas_y_tramos_de_escala_2024.add(AV17tramo, 0);
      AV17tramo = (web.Sdttasas_y_tramos_de_escala_tramo)new web.Sdttasas_y_tramos_de_escala_tramo(remoteHandle, context);
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta( DecimalUtil.stringToDec("6708063.39") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Importe( DecimalUtil.stringToDec("976861.71") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Masel( DecimalUtil.stringToDec("0.31") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Resto( DecimalUtil.stringToDec("5031047.45") );
      AV49tasas_y_tramos_de_escala_2024.add(AV17tramo, 0);
      AV17tramo = (web.Sdttasas_y_tramos_de_escala_tramo)new web.Sdttasas_y_tramos_de_escala_tramo(remoteHandle, context);
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta( DecimalUtil.stringToDec("99999999999.99") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Importe( DecimalUtil.stringToDec("1496736.65") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Masel( DecimalUtil.stringToDec("0.35") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Resto( DecimalUtil.stringToDec("6708063.39") );
      AV49tasas_y_tramos_de_escala_2024.add(AV17tramo, 0);
   }

   public void S131( )
   {
      /* 'TRAMOS GANANCIAS 2024 NUEVA' Routine */
      returnInSub = false ;
      AV17tramo = (web.Sdttasas_y_tramos_de_escala_tramo)new web.Sdttasas_y_tramos_de_escala_tramo(remoteHandle, context);
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta( DecimalUtil.doubleToDec(1200000) );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Importe( DecimalUtil.doubleToDec(0) );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Masel( DecimalUtil.stringToDec("0.05") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Resto( DecimalUtil.doubleToDec(0) );
      AV49tasas_y_tramos_de_escala_2024.add(AV17tramo, 0);
      AV17tramo = (web.Sdttasas_y_tramos_de_escala_tramo)new web.Sdttasas_y_tramos_de_escala_tramo(remoteHandle, context);
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta( DecimalUtil.doubleToDec(2400000) );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Importe( DecimalUtil.doubleToDec(60000) );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Masel( DecimalUtil.stringToDec("0.09") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Resto( DecimalUtil.doubleToDec(1200000) );
      AV49tasas_y_tramos_de_escala_2024.add(AV17tramo, 0);
      AV17tramo = (web.Sdttasas_y_tramos_de_escala_tramo)new web.Sdttasas_y_tramos_de_escala_tramo(remoteHandle, context);
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta( DecimalUtil.doubleToDec(3600000) );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Importe( DecimalUtil.doubleToDec(168000) );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Masel( DecimalUtil.stringToDec("0.12") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Resto( DecimalUtil.doubleToDec(2400000) );
      AV49tasas_y_tramos_de_escala_2024.add(AV17tramo, 0);
      AV17tramo = (web.Sdttasas_y_tramos_de_escala_tramo)new web.Sdttasas_y_tramos_de_escala_tramo(remoteHandle, context);
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta( DecimalUtil.doubleToDec(5400000) );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Importe( DecimalUtil.doubleToDec(312000) );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Masel( DecimalUtil.stringToDec("0.15") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Resto( DecimalUtil.doubleToDec(3600000) );
      AV49tasas_y_tramos_de_escala_2024.add(AV17tramo, 0);
      AV17tramo = (web.Sdttasas_y_tramos_de_escala_tramo)new web.Sdttasas_y_tramos_de_escala_tramo(remoteHandle, context);
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta( DecimalUtil.doubleToDec(10800000) );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Importe( DecimalUtil.doubleToDec(582000) );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Masel( DecimalUtil.stringToDec("0.19") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Resto( DecimalUtil.doubleToDec(5400000) );
      AV49tasas_y_tramos_de_escala_2024.add(AV17tramo, 0);
      AV17tramo = (web.Sdttasas_y_tramos_de_escala_tramo)new web.Sdttasas_y_tramos_de_escala_tramo(remoteHandle, context);
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta( DecimalUtil.doubleToDec(16200000) );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Importe( DecimalUtil.doubleToDec(1608000) );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Masel( DecimalUtil.stringToDec("0.23") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Resto( DecimalUtil.doubleToDec(10800000) );
      AV49tasas_y_tramos_de_escala_2024.add(AV17tramo, 0);
      AV17tramo = (web.Sdttasas_y_tramos_de_escala_tramo)new web.Sdttasas_y_tramos_de_escala_tramo(remoteHandle, context);
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta( DecimalUtil.doubleToDec(24300000) );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Importe( DecimalUtil.doubleToDec(2850000) );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Masel( DecimalUtil.stringToDec("0.27") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Resto( DecimalUtil.doubleToDec(16200000) );
      AV49tasas_y_tramos_de_escala_2024.add(AV17tramo, 0);
      AV17tramo = (web.Sdttasas_y_tramos_de_escala_tramo)new web.Sdttasas_y_tramos_de_escala_tramo(remoteHandle, context);
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta( DecimalUtil.doubleToDec(36450000) );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Importe( DecimalUtil.doubleToDec(5037000) );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Masel( DecimalUtil.stringToDec("0.31") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Resto( DecimalUtil.doubleToDec(24300000) );
      AV49tasas_y_tramos_de_escala_2024.add(AV17tramo, 0);
      AV17tramo = (web.Sdttasas_y_tramos_de_escala_tramo)new web.Sdttasas_y_tramos_de_escala_tramo(remoteHandle, context);
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta( DecimalUtil.stringToDec("99999999999.99") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Importe( DecimalUtil.doubleToDec(8803000) );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Masel( DecimalUtil.stringToDec("0.35") );
      AV17tramo.setgxTv_Sdttasas_y_tramos_de_escala_tramo_Resto( DecimalUtil.doubleToDec(36450000) );
      AV49tasas_y_tramos_de_escala_2024.add(AV17tramo, 0);
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV20primeroDeEnero2022 = GXutil.nullDate() ;
      AV21periodos = new GXSimpleCollection<java.util.Date>(java.util.Date.class, "internal", "");
      AV24marzoDate = GXutil.nullDate() ;
      AV23junio = GXutil.nullDate() ;
      AV28julio = GXutil.nullDate() ;
      AV25septiembreDate = GXutil.nullDate() ;
      AV27noviembreDate = GXutil.nullDate() ;
      AV26diciembreDate = GXutil.nullDate() ;
      AV29enero2023 = GXutil.nullDate() ;
      AV30febrero2023 = GXutil.nullDate() ;
      AV31marzo2023 = GXutil.nullDate() ;
      AV35abril2023 = GXutil.nullDate() ;
      AV34mayo2023 = GXutil.nullDate() ;
      AV37junio2023 = GXutil.nullDate() ;
      AV45julio2023 = GXutil.nullDate() ;
      AV42agosto2023 = GXutil.nullDate() ;
      AV48septiembre2023 = GXutil.nullDate() ;
      AV47octubre2023 = GXutil.nullDate() ;
      AV46noviembre2023 = GXutil.nullDate() ;
      AV43diciembre2023 = GXutil.nullDate() ;
      AV44enero2024 = GXutil.nullDate() ;
      AV51febrer2024 = GXutil.nullDate() ;
      AV50marzo2024 = GXutil.nullDate() ;
      AV52abril2024 = GXutil.nullDate() ;
      AV53mayo2024 = GXutil.nullDate() ;
      AV54junio2024 = GXutil.nullDate() ;
      AV55julio2024 = GXutil.nullDate() ;
      AV58GXV1 = new GXSimpleCollection<String>(String.class, "internal", "");
      AV10constante = "" ;
      AV14OpeCliValor = "" ;
      AV16tasas_y_tramos_de_escala = new GXBaseCollection<web.Sdttasas_y_tramos_de_escala_tramo>(web.Sdttasas_y_tramos_de_escala_tramo.class, "tramo", "PayDay", remoteHandle);
      AV17tramo = new web.Sdttasas_y_tramos_de_escala_tramo(remoteHandle, context);
      AV49tasas_y_tramos_de_escala_2024 = new GXBaseCollection<web.Sdttasas_y_tramos_de_escala_tramo>(web.Sdttasas_y_tramos_de_escala_tramo.class, "tramo", "PayDay", remoteHandle);
      AV41ley_27541_ali = new web.Sdtley_27541_ali(remoteHandle, context);
      AV40pctOSItem = new web.Sdtpct_os_fsr_pct_os_fsrItem(remoteHandle, context);
      AV38pct_os_fsr = new GXBaseCollection<web.Sdtpct_os_fsr_pct_os_fsrItem>(web.Sdtpct_os_fsr_pct_os_fsrItem.class, "pct_os_fsrItem", "PayDay", remoteHandle);
      GXv_char2 = new String[1] ;
      GXv_char1 = new String[1] ;
      AV13OpeCliId = "" ;
      AV36date = GXutil.nullDate() ;
      AV61Pgmname = "" ;
      AV61Pgmname = "IniOpeCliente" ;
      /* GeneXus formulas. */
      AV61Pgmname = "IniOpeCliente" ;
      Gx_err = (short)(0) ;
   }

   private short AV22i ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV59GXV2 ;
   private int AV60GXV3 ;
   private String AV10constante ;
   private String GXv_char2[] ;
   private String GXv_char1[] ;
   private String AV13OpeCliId ;
   private String AV61Pgmname ;
   private java.util.Date AV20primeroDeEnero2022 ;
   private java.util.Date AV24marzoDate ;
   private java.util.Date AV23junio ;
   private java.util.Date AV28julio ;
   private java.util.Date AV25septiembreDate ;
   private java.util.Date AV27noviembreDate ;
   private java.util.Date AV26diciembreDate ;
   private java.util.Date AV29enero2023 ;
   private java.util.Date AV30febrero2023 ;
   private java.util.Date AV31marzo2023 ;
   private java.util.Date AV35abril2023 ;
   private java.util.Date AV34mayo2023 ;
   private java.util.Date AV37junio2023 ;
   private java.util.Date AV45julio2023 ;
   private java.util.Date AV42agosto2023 ;
   private java.util.Date AV48septiembre2023 ;
   private java.util.Date AV47octubre2023 ;
   private java.util.Date AV46noviembre2023 ;
   private java.util.Date AV43diciembre2023 ;
   private java.util.Date AV44enero2024 ;
   private java.util.Date AV51febrer2024 ;
   private java.util.Date AV50marzo2024 ;
   private java.util.Date AV52abril2024 ;
   private java.util.Date AV53mayo2024 ;
   private java.util.Date AV54junio2024 ;
   private java.util.Date AV55julio2024 ;
   private java.util.Date AV36date ;
   private boolean returnInSub ;
   private boolean AV32OpeCliEsCant ;
   private boolean AV33OpeCliAliEs ;
   private String AV14OpeCliValor ;
   private GXBaseCollection<web.Sdttasas_y_tramos_de_escala_tramo> AV16tasas_y_tramos_de_escala ;
   private GXBaseCollection<web.Sdttasas_y_tramos_de_escala_tramo> AV49tasas_y_tramos_de_escala_2024 ;
   private web.Sdtley_27541_ali AV41ley_27541_ali ;
   private GXSimpleCollection<String> AV58GXV1 ;
   private GXSimpleCollection<java.util.Date> AV21periodos ;
   private GXBaseCollection<web.Sdtpct_os_fsr_pct_os_fsrItem> AV38pct_os_fsr ;
   private web.Sdtpct_os_fsr_pct_os_fsrItem AV40pctOSItem ;
   private web.Sdttasas_y_tramos_de_escala_tramo AV17tramo ;
}

