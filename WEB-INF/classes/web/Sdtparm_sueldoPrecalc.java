package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtparm_sueldoPrecalc extends GxUserType
{
   public Sdtparm_sueldoPrecalc( )
   {
      this(  new ModelContext(Sdtparm_sueldoPrecalc.class));
   }

   public Sdtparm_sueldoPrecalc( ModelContext context )
   {
      super( context, "Sdtparm_sueldoPrecalc");
   }

   public Sdtparm_sueldoPrecalc( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle, context, "Sdtparm_sueldoPrecalc");
   }

   public Sdtparm_sueldoPrecalc( StructSdtparm_sueldoPrecalc struct )
   {
      this();
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
      formatError = false ;
      sTagName = oReader.getName() ;
      if ( oReader.getIsSimple() == 0 )
      {
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            readElement = false ;
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod") )
            {
               gxTv_Sdtparm_sueldoPrecalc_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod") )
            {
               gxTv_Sdtparm_sueldoPrecalc_Empcod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegNumero") )
            {
               gxTv_Sdtparm_sueldoPrecalc_Legnumero = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSuelTipo") )
            {
               gxTv_Sdtparm_sueldoPrecalc_Legsueltipo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSuelFecha") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_Sdtparm_sueldoPrecalc_Legsuelfecha = GXutil.nullDate() ;
                  gxTv_Sdtparm_sueldoPrecalc_Legsuelfecha_N = (byte)(1) ;
               }
               else
               {
                  gxTv_Sdtparm_sueldoPrecalc_Legsuelfecha_N = (byte)(0) ;
                  gxTv_Sdtparm_sueldoPrecalc_Legsuelfecha = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSuelSec") )
            {
               gxTv_Sdtparm_sueldoPrecalc_Legsuelsec = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "parmImportes") )
            {
               gxTv_Sdtparm_sueldoPrecalc_Parmimportes = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "parmLegLiqApo") )
            {
               gxTv_Sdtparm_sueldoPrecalc_Parmlegliqapo = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "parmLegJubilado") )
            {
               gxTv_Sdtparm_sueldoPrecalc_Parmlegjubilado = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "parmSinCod") )
            {
               gxTv_Sdtparm_sueldoPrecalc_Parmsincod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "setCalcYTxt") )
            {
               gxTv_Sdtparm_sueldoPrecalc_Setcalcytxt = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( ! readElement )
            {
               readOk = (short)(1) ;
               GXSoapError = oReader.read() ;
            }
            nOutParmCount = (short)(nOutParmCount+1) ;
            if ( ( readOk == 0 ) || formatError )
            {
               context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
               context.globals.sSOAPErrMsg += "Message: " + oReader.readRawXML() ;
               GXSoapError = (short)(nOutParmCount*-1) ;
            }
         }
      }
      return GXSoapError ;
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace )
   {
      writexml(oWriter, sName, sNameSpace, true);
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace ,
                         boolean sIncludeState )
   {
      if ( (GXutil.strcmp("", sName)==0) )
      {
         sName = "parm_sueldoPrecalc" ;
      }
      if ( (GXutil.strcmp("", sNameSpace)==0) )
      {
         sNameSpace = "PayDay" ;
      }
      oWriter.writeStartElement(sName);
      if ( GXutil.strcmp(GXutil.left( sNameSpace, 10), "[*:nosend]") != 0 )
      {
         oWriter.writeAttribute("xmlns", sNameSpace);
      }
      else
      {
         sNameSpace = GXutil.right( sNameSpace, GXutil.len( sNameSpace)-10) ;
      }
      oWriter.writeElement("CliCod", GXutil.trim( GXutil.str( gxTv_Sdtparm_sueldoPrecalc_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpCod", GXutil.trim( GXutil.str( gxTv_Sdtparm_sueldoPrecalc_Empcod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegNumero", GXutil.trim( GXutil.str( gxTv_Sdtparm_sueldoPrecalc_Legnumero, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegSuelTipo", gxTv_Sdtparm_sueldoPrecalc_Legsueltipo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_Sdtparm_sueldoPrecalc_Legsuelfecha)) && ( gxTv_Sdtparm_sueldoPrecalc_Legsuelfecha_N == 1 ) )
      {
         oWriter.writeElement("LegSuelFecha", "");
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtparm_sueldoPrecalc_Legsuelfecha), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtparm_sueldoPrecalc_Legsuelfecha), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtparm_sueldoPrecalc_Legsuelfecha), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LegSuelFecha", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      oWriter.writeElement("LegSuelSec", GXutil.trim( GXutil.str( gxTv_Sdtparm_sueldoPrecalc_Legsuelsec, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("parmImportes", GXutil.trim( GXutil.strNoRound( gxTv_Sdtparm_sueldoPrecalc_Parmimportes, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("parmLegLiqApo", GXutil.booltostr( gxTv_Sdtparm_sueldoPrecalc_Parmlegliqapo));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("parmLegJubilado", GXutil.booltostr( gxTv_Sdtparm_sueldoPrecalc_Parmlegjubilado));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("parmSinCod", gxTv_Sdtparm_sueldoPrecalc_Parmsincod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("setCalcYTxt", GXutil.booltostr( gxTv_Sdtparm_sueldoPrecalc_Setcalcytxt));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeEndElement();
   }

   public long getnumericvalue( String value )
   {
      if ( GXutil.notNumeric( value) )
      {
         formatError = true ;
      }
      return GXutil.lval( value) ;
   }

   public void tojson( )
   {
      tojson( true) ;
   }

   public void tojson( boolean includeState )
   {
      tojson( includeState, true) ;
   }

   public void tojson( boolean includeState ,
                       boolean includeNonInitialized )
   {
      AddObjectProperty("CliCod", gxTv_Sdtparm_sueldoPrecalc_Clicod, false, false);
      AddObjectProperty("EmpCod", gxTv_Sdtparm_sueldoPrecalc_Empcod, false, false);
      AddObjectProperty("LegNumero", gxTv_Sdtparm_sueldoPrecalc_Legnumero, false, false);
      AddObjectProperty("LegSuelTipo", gxTv_Sdtparm_sueldoPrecalc_Legsueltipo, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtparm_sueldoPrecalc_Legsuelfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtparm_sueldoPrecalc_Legsuelfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtparm_sueldoPrecalc_Legsuelfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LegSuelFecha", sDateCnv, false, false);
      AddObjectProperty("LegSuelSec", gxTv_Sdtparm_sueldoPrecalc_Legsuelsec, false, false);
      AddObjectProperty("parmImportes", gxTv_Sdtparm_sueldoPrecalc_Parmimportes, false, false);
      AddObjectProperty("parmLegLiqApo", gxTv_Sdtparm_sueldoPrecalc_Parmlegliqapo, false, false);
      AddObjectProperty("parmLegJubilado", gxTv_Sdtparm_sueldoPrecalc_Parmlegjubilado, false, false);
      AddObjectProperty("parmSinCod", gxTv_Sdtparm_sueldoPrecalc_Parmsincod, false, false);
      AddObjectProperty("setCalcYTxt", gxTv_Sdtparm_sueldoPrecalc_Setcalcytxt, false, false);
   }

   public int getgxTv_Sdtparm_sueldoPrecalc_Clicod( )
   {
      return gxTv_Sdtparm_sueldoPrecalc_Clicod ;
   }

   public void setgxTv_Sdtparm_sueldoPrecalc_Clicod( int value )
   {
      gxTv_Sdtparm_sueldoPrecalc_N = (byte)(0) ;
      gxTv_Sdtparm_sueldoPrecalc_Clicod = value ;
   }

   public short getgxTv_Sdtparm_sueldoPrecalc_Empcod( )
   {
      return gxTv_Sdtparm_sueldoPrecalc_Empcod ;
   }

   public void setgxTv_Sdtparm_sueldoPrecalc_Empcod( short value )
   {
      gxTv_Sdtparm_sueldoPrecalc_N = (byte)(0) ;
      gxTv_Sdtparm_sueldoPrecalc_Empcod = value ;
   }

   public int getgxTv_Sdtparm_sueldoPrecalc_Legnumero( )
   {
      return gxTv_Sdtparm_sueldoPrecalc_Legnumero ;
   }

   public void setgxTv_Sdtparm_sueldoPrecalc_Legnumero( int value )
   {
      gxTv_Sdtparm_sueldoPrecalc_N = (byte)(0) ;
      gxTv_Sdtparm_sueldoPrecalc_Legnumero = value ;
   }

   public String getgxTv_Sdtparm_sueldoPrecalc_Legsueltipo( )
   {
      return gxTv_Sdtparm_sueldoPrecalc_Legsueltipo ;
   }

   public void setgxTv_Sdtparm_sueldoPrecalc_Legsueltipo( String value )
   {
      gxTv_Sdtparm_sueldoPrecalc_N = (byte)(0) ;
      gxTv_Sdtparm_sueldoPrecalc_Legsueltipo = value ;
   }

   public java.util.Date getgxTv_Sdtparm_sueldoPrecalc_Legsuelfecha( )
   {
      return gxTv_Sdtparm_sueldoPrecalc_Legsuelfecha ;
   }

   public void setgxTv_Sdtparm_sueldoPrecalc_Legsuelfecha( java.util.Date value )
   {
      gxTv_Sdtparm_sueldoPrecalc_Legsuelfecha_N = (byte)(0) ;
      gxTv_Sdtparm_sueldoPrecalc_N = (byte)(0) ;
      gxTv_Sdtparm_sueldoPrecalc_Legsuelfecha = value ;
   }

   public short getgxTv_Sdtparm_sueldoPrecalc_Legsuelsec( )
   {
      return gxTv_Sdtparm_sueldoPrecalc_Legsuelsec ;
   }

   public void setgxTv_Sdtparm_sueldoPrecalc_Legsuelsec( short value )
   {
      gxTv_Sdtparm_sueldoPrecalc_N = (byte)(0) ;
      gxTv_Sdtparm_sueldoPrecalc_Legsuelsec = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtparm_sueldoPrecalc_Parmimportes( )
   {
      return gxTv_Sdtparm_sueldoPrecalc_Parmimportes ;
   }

   public void setgxTv_Sdtparm_sueldoPrecalc_Parmimportes( java.math.BigDecimal value )
   {
      gxTv_Sdtparm_sueldoPrecalc_N = (byte)(0) ;
      gxTv_Sdtparm_sueldoPrecalc_Parmimportes = value ;
   }

   public boolean getgxTv_Sdtparm_sueldoPrecalc_Parmlegliqapo( )
   {
      return gxTv_Sdtparm_sueldoPrecalc_Parmlegliqapo ;
   }

   public void setgxTv_Sdtparm_sueldoPrecalc_Parmlegliqapo( boolean value )
   {
      gxTv_Sdtparm_sueldoPrecalc_N = (byte)(0) ;
      gxTv_Sdtparm_sueldoPrecalc_Parmlegliqapo = value ;
   }

   public boolean getgxTv_Sdtparm_sueldoPrecalc_Parmlegjubilado( )
   {
      return gxTv_Sdtparm_sueldoPrecalc_Parmlegjubilado ;
   }

   public void setgxTv_Sdtparm_sueldoPrecalc_Parmlegjubilado( boolean value )
   {
      gxTv_Sdtparm_sueldoPrecalc_N = (byte)(0) ;
      gxTv_Sdtparm_sueldoPrecalc_Parmlegjubilado = value ;
   }

   public String getgxTv_Sdtparm_sueldoPrecalc_Parmsincod( )
   {
      return gxTv_Sdtparm_sueldoPrecalc_Parmsincod ;
   }

   public void setgxTv_Sdtparm_sueldoPrecalc_Parmsincod( String value )
   {
      gxTv_Sdtparm_sueldoPrecalc_N = (byte)(0) ;
      gxTv_Sdtparm_sueldoPrecalc_Parmsincod = value ;
   }

   public boolean getgxTv_Sdtparm_sueldoPrecalc_Setcalcytxt( )
   {
      return gxTv_Sdtparm_sueldoPrecalc_Setcalcytxt ;
   }

   public void setgxTv_Sdtparm_sueldoPrecalc_Setcalcytxt( boolean value )
   {
      gxTv_Sdtparm_sueldoPrecalc_N = (byte)(0) ;
      gxTv_Sdtparm_sueldoPrecalc_Setcalcytxt = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtparm_sueldoPrecalc_N = (byte)(1) ;
      gxTv_Sdtparm_sueldoPrecalc_Legsueltipo = "" ;
      gxTv_Sdtparm_sueldoPrecalc_Legsuelfecha = GXutil.nullDate() ;
      gxTv_Sdtparm_sueldoPrecalc_Legsuelfecha_N = (byte)(1) ;
      gxTv_Sdtparm_sueldoPrecalc_Parmimportes = DecimalUtil.ZERO ;
      gxTv_Sdtparm_sueldoPrecalc_Parmsincod = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtparm_sueldoPrecalc_N ;
   }

   public web.Sdtparm_sueldoPrecalc Clone( )
   {
      return (web.Sdtparm_sueldoPrecalc)(clone()) ;
   }

   public void setStruct( web.StructSdtparm_sueldoPrecalc struct )
   {
      setgxTv_Sdtparm_sueldoPrecalc_Clicod(struct.getClicod());
      setgxTv_Sdtparm_sueldoPrecalc_Empcod(struct.getEmpcod());
      setgxTv_Sdtparm_sueldoPrecalc_Legnumero(struct.getLegnumero());
      setgxTv_Sdtparm_sueldoPrecalc_Legsueltipo(struct.getLegsueltipo());
      if ( struct.gxTv_Sdtparm_sueldoPrecalc_Legsuelfecha_N == 0 )
      {
         setgxTv_Sdtparm_sueldoPrecalc_Legsuelfecha(struct.getLegsuelfecha());
      }
      setgxTv_Sdtparm_sueldoPrecalc_Legsuelsec(struct.getLegsuelsec());
      setgxTv_Sdtparm_sueldoPrecalc_Parmimportes(struct.getParmimportes());
      setgxTv_Sdtparm_sueldoPrecalc_Parmlegliqapo(struct.getParmlegliqapo());
      setgxTv_Sdtparm_sueldoPrecalc_Parmlegjubilado(struct.getParmlegjubilado());
      setgxTv_Sdtparm_sueldoPrecalc_Parmsincod(struct.getParmsincod());
      setgxTv_Sdtparm_sueldoPrecalc_Setcalcytxt(struct.getSetcalcytxt());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtparm_sueldoPrecalc getStruct( )
   {
      web.StructSdtparm_sueldoPrecalc struct = new web.StructSdtparm_sueldoPrecalc ();
      struct.setClicod(getgxTv_Sdtparm_sueldoPrecalc_Clicod());
      struct.setEmpcod(getgxTv_Sdtparm_sueldoPrecalc_Empcod());
      struct.setLegnumero(getgxTv_Sdtparm_sueldoPrecalc_Legnumero());
      struct.setLegsueltipo(getgxTv_Sdtparm_sueldoPrecalc_Legsueltipo());
      if ( gxTv_Sdtparm_sueldoPrecalc_Legsuelfecha_N == 0 )
      {
         struct.setLegsuelfecha(getgxTv_Sdtparm_sueldoPrecalc_Legsuelfecha());
      }
      struct.setLegsuelsec(getgxTv_Sdtparm_sueldoPrecalc_Legsuelsec());
      struct.setParmimportes(getgxTv_Sdtparm_sueldoPrecalc_Parmimportes());
      struct.setParmlegliqapo(getgxTv_Sdtparm_sueldoPrecalc_Parmlegliqapo());
      struct.setParmlegjubilado(getgxTv_Sdtparm_sueldoPrecalc_Parmlegjubilado());
      struct.setParmsincod(getgxTv_Sdtparm_sueldoPrecalc_Parmsincod());
      struct.setSetcalcytxt(getgxTv_Sdtparm_sueldoPrecalc_Setcalcytxt());
      return struct ;
   }

   protected byte gxTv_Sdtparm_sueldoPrecalc_N ;
   protected byte gxTv_Sdtparm_sueldoPrecalc_Legsuelfecha_N ;
   protected short gxTv_Sdtparm_sueldoPrecalc_Empcod ;
   protected short gxTv_Sdtparm_sueldoPrecalc_Legsuelsec ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_Sdtparm_sueldoPrecalc_Clicod ;
   protected int gxTv_Sdtparm_sueldoPrecalc_Legnumero ;
   protected java.math.BigDecimal gxTv_Sdtparm_sueldoPrecalc_Parmimportes ;
   protected String gxTv_Sdtparm_sueldoPrecalc_Legsueltipo ;
   protected String gxTv_Sdtparm_sueldoPrecalc_Parmsincod ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_Sdtparm_sueldoPrecalc_Legsuelfecha ;
   protected boolean gxTv_Sdtparm_sueldoPrecalc_Parmlegliqapo ;
   protected boolean gxTv_Sdtparm_sueldoPrecalc_Parmlegjubilado ;
   protected boolean gxTv_Sdtparm_sueldoPrecalc_Setcalcytxt ;
   protected boolean readElement ;
   protected boolean formatError ;
}

