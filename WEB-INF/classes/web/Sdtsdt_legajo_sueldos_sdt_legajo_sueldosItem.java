package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem extends GxUserType
{
   public Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem( )
   {
      this(  new ModelContext(Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem.class));
   }

   public Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem( ModelContext context )
   {
      super( context, "Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem");
   }

   public Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem( int remoteHandle ,
                                                        ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem");
   }

   public Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem( StructSdtsdt_legajo_sueldos_sdt_legajo_sueldosItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Empcod") )
            {
               gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Empcod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegNumero") )
            {
               gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legnumero = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSuelSec") )
            {
               gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelsec = (short)(getnumericvalue(oReader.getValue())) ;
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
                  gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelfecha = GXutil.nullDate() ;
                  gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelfecha_N = (byte)(1) ;
               }
               else
               {
                  gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelfecha_N = (byte)(0) ;
                  gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelfecha = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSuelImporte") )
            {
               gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelimporte = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSuelTipo") )
            {
               gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsueltipo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod") )
            {
               gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSuelCalc") )
            {
               gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelcalc = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegSuelLog") )
            {
               gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuellog = oReader.getValue() ;
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
         sName = "sdt_legajo_sueldos.sdt_legajo_sueldosItem" ;
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
      oWriter.writeElement("Empcod", GXutil.trim( GXutil.str( gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Empcod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegNumero", GXutil.trim( GXutil.str( gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legnumero, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegSuelSec", GXutil.trim( GXutil.str( gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelsec, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelfecha)) && ( gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelfecha_N == 1 ) )
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
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelfecha), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelfecha), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelfecha), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LegSuelFecha", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      oWriter.writeElement("LegSuelImporte", GXutil.trim( GXutil.strNoRound( gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelimporte, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegSuelTipo", gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsueltipo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CliCod", GXutil.trim( GXutil.str( gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegSuelCalc", GXutil.trim( GXutil.strNoRound( gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelcalc, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegSuelLog", gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuellog);
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
      AddObjectProperty("Empcod", gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Empcod, false, false);
      AddObjectProperty("LegNumero", gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legnumero, false, false);
      AddObjectProperty("LegSuelSec", gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelsec, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LegSuelFecha", sDateCnv, false, false);
      AddObjectProperty("LegSuelImporte", gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelimporte, false, false);
      AddObjectProperty("LegSuelTipo", gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsueltipo, false, false);
      AddObjectProperty("CliCod", gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Clicod, false, false);
      AddObjectProperty("LegSuelCalc", gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelcalc, false, false);
      AddObjectProperty("LegSuelLog", gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuellog, false, false);
   }

   public short getgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Empcod( )
   {
      return gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Empcod ;
   }

   public void setgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Empcod( short value )
   {
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Empcod = value ;
   }

   public int getgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legnumero( )
   {
      return gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legnumero ;
   }

   public void setgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legnumero( int value )
   {
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legnumero = value ;
   }

   public short getgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelsec( )
   {
      return gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelsec ;
   }

   public void setgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelsec( short value )
   {
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelsec = value ;
   }

   public java.util.Date getgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelfecha( )
   {
      return gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelfecha ;
   }

   public void setgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelfecha( java.util.Date value )
   {
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelfecha_N = (byte)(0) ;
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelfecha = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelimporte( )
   {
      return gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelimporte ;
   }

   public void setgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelimporte( java.math.BigDecimal value )
   {
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelimporte = value ;
   }

   public String getgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsueltipo( )
   {
      return gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsueltipo ;
   }

   public void setgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsueltipo( String value )
   {
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsueltipo = value ;
   }

   public int getgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Clicod( )
   {
      return gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Clicod ;
   }

   public void setgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Clicod( int value )
   {
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Clicod = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelcalc( )
   {
      return gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelcalc ;
   }

   public void setgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelcalc( java.math.BigDecimal value )
   {
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelcalc = value ;
   }

   public String getgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuellog( )
   {
      return gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuellog ;
   }

   public void setgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuellog( String value )
   {
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuellog = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_N = (byte)(1) ;
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelfecha = GXutil.nullDate() ;
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelfecha_N = (byte)(1) ;
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelimporte = DecimalUtil.ZERO ;
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsueltipo = "" ;
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelcalc = DecimalUtil.ZERO ;
      gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuellog = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_N ;
   }

   public web.Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem Clone( )
   {
      return (web.Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_legajo_sueldos_sdt_legajo_sueldosItem struct )
   {
      setgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Empcod(struct.getEmpcod());
      setgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legnumero(struct.getLegnumero());
      setgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelsec(struct.getLegsuelsec());
      if ( struct.gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelfecha_N == 0 )
      {
         setgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelfecha(struct.getLegsuelfecha());
      }
      setgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelimporte(struct.getLegsuelimporte());
      setgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsueltipo(struct.getLegsueltipo());
      setgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Clicod(struct.getClicod());
      setgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelcalc(struct.getLegsuelcalc());
      setgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuellog(struct.getLegsuellog());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_legajo_sueldos_sdt_legajo_sueldosItem getStruct( )
   {
      web.StructSdtsdt_legajo_sueldos_sdt_legajo_sueldosItem struct = new web.StructSdtsdt_legajo_sueldos_sdt_legajo_sueldosItem ();
      struct.setEmpcod(getgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Empcod());
      struct.setLegnumero(getgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legnumero());
      struct.setLegsuelsec(getgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelsec());
      if ( gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelfecha_N == 0 )
      {
         struct.setLegsuelfecha(getgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelfecha());
      }
      struct.setLegsuelimporte(getgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelimporte());
      struct.setLegsueltipo(getgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsueltipo());
      struct.setClicod(getgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Clicod());
      struct.setLegsuelcalc(getgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelcalc());
      struct.setLegsuellog(getgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuellog());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_N ;
   protected byte gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelfecha_N ;
   protected short gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Empcod ;
   protected short gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelsec ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legnumero ;
   protected int gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Clicod ;
   protected java.math.BigDecimal gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelimporte ;
   protected java.math.BigDecimal gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelcalc ;
   protected String gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsueltipo ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelfecha ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuellog ;
}

