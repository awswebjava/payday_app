package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtConvenio_base_calculo_old extends GxUserType
{
   public SdtConvenio_base_calculo_old( )
   {
      this(  new ModelContext(SdtConvenio_base_calculo_old.class));
   }

   public SdtConvenio_base_calculo_old( ModelContext context )
   {
      super( context, "SdtConvenio_base_calculo_old");
   }

   public SdtConvenio_base_calculo_old( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle, context, "SdtConvenio_base_calculo_old");
   }

   public SdtConvenio_base_calculo_old( StructSdtConvenio_base_calculo_old struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveBasePlus") )
            {
               gxTv_SdtConvenio_base_calculo_old_Convebaseplus = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveLicDLim") )
            {
               gxTv_SdtConvenio_base_calculo_old_Convelicdlim = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveLicDSeman") )
            {
               gxTv_SdtConvenio_base_calculo_old_Convelicdseman = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveLicDMes") )
            {
               gxTv_SdtConvenio_base_calculo_old_Convelicdmes = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveLicDSemes") )
            {
               gxTv_SdtConvenio_base_calculo_old_Convelicdsemes = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveLicDAnual") )
            {
               gxTv_SdtConvenio_base_calculo_old_Convelicdanual = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveLicAdju") )
            {
               gxTv_SdtConvenio_base_calculo_old_Convelicadju = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveLicAdjuObl") )
            {
               gxTv_SdtConvenio_base_calculo_old_Convelicadjuobl = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveLicNecAut") )
            {
               gxTv_SdtConvenio_base_calculo_old_Convelicnecaut = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveLicIngMot") )
            {
               gxTv_SdtConvenio_base_calculo_old_Convelicingmot = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveLicMotObl") )
            {
               gxTv_SdtConvenio_base_calculo_old_Convelicmotobl = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveBasePromCnt1") )
            {
               gxTv_SdtConvenio_base_calculo_old_Convebasepromcnt1 = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveBasePromCnt2") )
            {
               gxTv_SdtConvenio_base_calculo_old_Convebasepromcnt2 = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveBasePromTCnt") )
            {
               gxTv_SdtConvenio_base_calculo_old_Convebasepromtcnt = oReader.getValue() ;
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
         sName = "Convenio_base_calculo_old" ;
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
      oWriter.writeElement("ConveBasePlus", GXutil.trim( GXutil.strNoRound( gxTv_SdtConvenio_base_calculo_old_Convebaseplus, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveLicDLim", GXutil.trim( GXutil.str( gxTv_SdtConvenio_base_calculo_old_Convelicdlim, 3, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveLicDSeman", GXutil.trim( GXutil.str( gxTv_SdtConvenio_base_calculo_old_Convelicdseman, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveLicDMes", GXutil.trim( GXutil.str( gxTv_SdtConvenio_base_calculo_old_Convelicdmes, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveLicDSemes", GXutil.trim( GXutil.str( gxTv_SdtConvenio_base_calculo_old_Convelicdsemes, 3, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveLicDAnual", GXutil.trim( GXutil.str( gxTv_SdtConvenio_base_calculo_old_Convelicdanual, 3, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveLicAdju", GXutil.booltostr( gxTv_SdtConvenio_base_calculo_old_Convelicadju));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveLicAdjuObl", GXutil.booltostr( gxTv_SdtConvenio_base_calculo_old_Convelicadjuobl));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveLicNecAut", GXutil.booltostr( gxTv_SdtConvenio_base_calculo_old_Convelicnecaut));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveLicIngMot", GXutil.booltostr( gxTv_SdtConvenio_base_calculo_old_Convelicingmot));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveLicMotObl", GXutil.booltostr( gxTv_SdtConvenio_base_calculo_old_Convelicmotobl));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveBasePromCnt1", GXutil.trim( GXutil.str( gxTv_SdtConvenio_base_calculo_old_Convebasepromcnt1, 3, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveBasePromCnt2", GXutil.trim( GXutil.str( gxTv_SdtConvenio_base_calculo_old_Convebasepromcnt2, 3, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveBasePromTCnt", gxTv_SdtConvenio_base_calculo_old_Convebasepromtcnt);
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
      AddObjectProperty("ConveBasePlus", gxTv_SdtConvenio_base_calculo_old_Convebaseplus, false, false);
      AddObjectProperty("ConveLicDLim", gxTv_SdtConvenio_base_calculo_old_Convelicdlim, false, false);
      AddObjectProperty("ConveLicDSeman", gxTv_SdtConvenio_base_calculo_old_Convelicdseman, false, false);
      AddObjectProperty("ConveLicDMes", gxTv_SdtConvenio_base_calculo_old_Convelicdmes, false, false);
      AddObjectProperty("ConveLicDSemes", gxTv_SdtConvenio_base_calculo_old_Convelicdsemes, false, false);
      AddObjectProperty("ConveLicDAnual", gxTv_SdtConvenio_base_calculo_old_Convelicdanual, false, false);
      AddObjectProperty("ConveLicAdju", gxTv_SdtConvenio_base_calculo_old_Convelicadju, false, false);
      AddObjectProperty("ConveLicAdjuObl", gxTv_SdtConvenio_base_calculo_old_Convelicadjuobl, false, false);
      AddObjectProperty("ConveLicNecAut", gxTv_SdtConvenio_base_calculo_old_Convelicnecaut, false, false);
      AddObjectProperty("ConveLicIngMot", gxTv_SdtConvenio_base_calculo_old_Convelicingmot, false, false);
      AddObjectProperty("ConveLicMotObl", gxTv_SdtConvenio_base_calculo_old_Convelicmotobl, false, false);
      AddObjectProperty("ConveBasePromCnt1", gxTv_SdtConvenio_base_calculo_old_Convebasepromcnt1, false, false);
      AddObjectProperty("ConveBasePromCnt2", gxTv_SdtConvenio_base_calculo_old_Convebasepromcnt2, false, false);
      AddObjectProperty("ConveBasePromTCnt", gxTv_SdtConvenio_base_calculo_old_Convebasepromtcnt, false, false);
   }

   public java.math.BigDecimal getgxTv_SdtConvenio_base_calculo_old_Convebaseplus( )
   {
      return gxTv_SdtConvenio_base_calculo_old_Convebaseplus ;
   }

   public void setgxTv_SdtConvenio_base_calculo_old_Convebaseplus( java.math.BigDecimal value )
   {
      gxTv_SdtConvenio_base_calculo_old_N = (byte)(0) ;
      gxTv_SdtConvenio_base_calculo_old_Convebaseplus = value ;
   }

   public short getgxTv_SdtConvenio_base_calculo_old_Convelicdlim( )
   {
      return gxTv_SdtConvenio_base_calculo_old_Convelicdlim ;
   }

   public void setgxTv_SdtConvenio_base_calculo_old_Convelicdlim( short value )
   {
      gxTv_SdtConvenio_base_calculo_old_N = (byte)(0) ;
      gxTv_SdtConvenio_base_calculo_old_Convelicdlim = value ;
   }

   public byte getgxTv_SdtConvenio_base_calculo_old_Convelicdseman( )
   {
      return gxTv_SdtConvenio_base_calculo_old_Convelicdseman ;
   }

   public void setgxTv_SdtConvenio_base_calculo_old_Convelicdseman( byte value )
   {
      gxTv_SdtConvenio_base_calculo_old_N = (byte)(0) ;
      gxTv_SdtConvenio_base_calculo_old_Convelicdseman = value ;
   }

   public byte getgxTv_SdtConvenio_base_calculo_old_Convelicdmes( )
   {
      return gxTv_SdtConvenio_base_calculo_old_Convelicdmes ;
   }

   public void setgxTv_SdtConvenio_base_calculo_old_Convelicdmes( byte value )
   {
      gxTv_SdtConvenio_base_calculo_old_N = (byte)(0) ;
      gxTv_SdtConvenio_base_calculo_old_Convelicdmes = value ;
   }

   public short getgxTv_SdtConvenio_base_calculo_old_Convelicdsemes( )
   {
      return gxTv_SdtConvenio_base_calculo_old_Convelicdsemes ;
   }

   public void setgxTv_SdtConvenio_base_calculo_old_Convelicdsemes( short value )
   {
      gxTv_SdtConvenio_base_calculo_old_N = (byte)(0) ;
      gxTv_SdtConvenio_base_calculo_old_Convelicdsemes = value ;
   }

   public short getgxTv_SdtConvenio_base_calculo_old_Convelicdanual( )
   {
      return gxTv_SdtConvenio_base_calculo_old_Convelicdanual ;
   }

   public void setgxTv_SdtConvenio_base_calculo_old_Convelicdanual( short value )
   {
      gxTv_SdtConvenio_base_calculo_old_N = (byte)(0) ;
      gxTv_SdtConvenio_base_calculo_old_Convelicdanual = value ;
   }

   public boolean getgxTv_SdtConvenio_base_calculo_old_Convelicadju( )
   {
      return gxTv_SdtConvenio_base_calculo_old_Convelicadju ;
   }

   public void setgxTv_SdtConvenio_base_calculo_old_Convelicadju( boolean value )
   {
      gxTv_SdtConvenio_base_calculo_old_N = (byte)(0) ;
      gxTv_SdtConvenio_base_calculo_old_Convelicadju = value ;
   }

   public boolean getgxTv_SdtConvenio_base_calculo_old_Convelicadjuobl( )
   {
      return gxTv_SdtConvenio_base_calculo_old_Convelicadjuobl ;
   }

   public void setgxTv_SdtConvenio_base_calculo_old_Convelicadjuobl( boolean value )
   {
      gxTv_SdtConvenio_base_calculo_old_N = (byte)(0) ;
      gxTv_SdtConvenio_base_calculo_old_Convelicadjuobl = value ;
   }

   public boolean getgxTv_SdtConvenio_base_calculo_old_Convelicnecaut( )
   {
      return gxTv_SdtConvenio_base_calculo_old_Convelicnecaut ;
   }

   public void setgxTv_SdtConvenio_base_calculo_old_Convelicnecaut( boolean value )
   {
      gxTv_SdtConvenio_base_calculo_old_N = (byte)(0) ;
      gxTv_SdtConvenio_base_calculo_old_Convelicnecaut = value ;
   }

   public boolean getgxTv_SdtConvenio_base_calculo_old_Convelicingmot( )
   {
      return gxTv_SdtConvenio_base_calculo_old_Convelicingmot ;
   }

   public void setgxTv_SdtConvenio_base_calculo_old_Convelicingmot( boolean value )
   {
      gxTv_SdtConvenio_base_calculo_old_N = (byte)(0) ;
      gxTv_SdtConvenio_base_calculo_old_Convelicingmot = value ;
   }

   public boolean getgxTv_SdtConvenio_base_calculo_old_Convelicmotobl( )
   {
      return gxTv_SdtConvenio_base_calculo_old_Convelicmotobl ;
   }

   public void setgxTv_SdtConvenio_base_calculo_old_Convelicmotobl( boolean value )
   {
      gxTv_SdtConvenio_base_calculo_old_N = (byte)(0) ;
      gxTv_SdtConvenio_base_calculo_old_Convelicmotobl = value ;
   }

   public short getgxTv_SdtConvenio_base_calculo_old_Convebasepromcnt1( )
   {
      return gxTv_SdtConvenio_base_calculo_old_Convebasepromcnt1 ;
   }

   public void setgxTv_SdtConvenio_base_calculo_old_Convebasepromcnt1( short value )
   {
      gxTv_SdtConvenio_base_calculo_old_N = (byte)(0) ;
      gxTv_SdtConvenio_base_calculo_old_Convebasepromcnt1 = value ;
   }

   public short getgxTv_SdtConvenio_base_calculo_old_Convebasepromcnt2( )
   {
      return gxTv_SdtConvenio_base_calculo_old_Convebasepromcnt2 ;
   }

   public void setgxTv_SdtConvenio_base_calculo_old_Convebasepromcnt2( short value )
   {
      gxTv_SdtConvenio_base_calculo_old_N = (byte)(0) ;
      gxTv_SdtConvenio_base_calculo_old_Convebasepromcnt2 = value ;
   }

   public String getgxTv_SdtConvenio_base_calculo_old_Convebasepromtcnt( )
   {
      return gxTv_SdtConvenio_base_calculo_old_Convebasepromtcnt ;
   }

   public void setgxTv_SdtConvenio_base_calculo_old_Convebasepromtcnt( String value )
   {
      gxTv_SdtConvenio_base_calculo_old_N = (byte)(0) ;
      gxTv_SdtConvenio_base_calculo_old_Convebasepromtcnt = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtConvenio_base_calculo_old_Convebaseplus = DecimalUtil.ZERO ;
      gxTv_SdtConvenio_base_calculo_old_N = (byte)(1) ;
      gxTv_SdtConvenio_base_calculo_old_Convebasepromtcnt = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtConvenio_base_calculo_old_N ;
   }

   public web.SdtConvenio_base_calculo_old Clone( )
   {
      return (web.SdtConvenio_base_calculo_old)(clone()) ;
   }

   public void setStruct( web.StructSdtConvenio_base_calculo_old struct )
   {
      setgxTv_SdtConvenio_base_calculo_old_Convebaseplus(struct.getConvebaseplus());
      setgxTv_SdtConvenio_base_calculo_old_Convelicdlim(struct.getConvelicdlim());
      setgxTv_SdtConvenio_base_calculo_old_Convelicdseman(struct.getConvelicdseman());
      setgxTv_SdtConvenio_base_calculo_old_Convelicdmes(struct.getConvelicdmes());
      setgxTv_SdtConvenio_base_calculo_old_Convelicdsemes(struct.getConvelicdsemes());
      setgxTv_SdtConvenio_base_calculo_old_Convelicdanual(struct.getConvelicdanual());
      setgxTv_SdtConvenio_base_calculo_old_Convelicadju(struct.getConvelicadju());
      setgxTv_SdtConvenio_base_calculo_old_Convelicadjuobl(struct.getConvelicadjuobl());
      setgxTv_SdtConvenio_base_calculo_old_Convelicnecaut(struct.getConvelicnecaut());
      setgxTv_SdtConvenio_base_calculo_old_Convelicingmot(struct.getConvelicingmot());
      setgxTv_SdtConvenio_base_calculo_old_Convelicmotobl(struct.getConvelicmotobl());
      setgxTv_SdtConvenio_base_calculo_old_Convebasepromcnt1(struct.getConvebasepromcnt1());
      setgxTv_SdtConvenio_base_calculo_old_Convebasepromcnt2(struct.getConvebasepromcnt2());
      setgxTv_SdtConvenio_base_calculo_old_Convebasepromtcnt(struct.getConvebasepromtcnt());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtConvenio_base_calculo_old getStruct( )
   {
      web.StructSdtConvenio_base_calculo_old struct = new web.StructSdtConvenio_base_calculo_old ();
      struct.setConvebaseplus(getgxTv_SdtConvenio_base_calculo_old_Convebaseplus());
      struct.setConvelicdlim(getgxTv_SdtConvenio_base_calculo_old_Convelicdlim());
      struct.setConvelicdseman(getgxTv_SdtConvenio_base_calculo_old_Convelicdseman());
      struct.setConvelicdmes(getgxTv_SdtConvenio_base_calculo_old_Convelicdmes());
      struct.setConvelicdsemes(getgxTv_SdtConvenio_base_calculo_old_Convelicdsemes());
      struct.setConvelicdanual(getgxTv_SdtConvenio_base_calculo_old_Convelicdanual());
      struct.setConvelicadju(getgxTv_SdtConvenio_base_calculo_old_Convelicadju());
      struct.setConvelicadjuobl(getgxTv_SdtConvenio_base_calculo_old_Convelicadjuobl());
      struct.setConvelicnecaut(getgxTv_SdtConvenio_base_calculo_old_Convelicnecaut());
      struct.setConvelicingmot(getgxTv_SdtConvenio_base_calculo_old_Convelicingmot());
      struct.setConvelicmotobl(getgxTv_SdtConvenio_base_calculo_old_Convelicmotobl());
      struct.setConvebasepromcnt1(getgxTv_SdtConvenio_base_calculo_old_Convebasepromcnt1());
      struct.setConvebasepromcnt2(getgxTv_SdtConvenio_base_calculo_old_Convebasepromcnt2());
      struct.setConvebasepromtcnt(getgxTv_SdtConvenio_base_calculo_old_Convebasepromtcnt());
      return struct ;
   }

   protected byte gxTv_SdtConvenio_base_calculo_old_N ;
   protected byte gxTv_SdtConvenio_base_calculo_old_Convelicdseman ;
   protected byte gxTv_SdtConvenio_base_calculo_old_Convelicdmes ;
   protected short gxTv_SdtConvenio_base_calculo_old_Convelicdlim ;
   protected short gxTv_SdtConvenio_base_calculo_old_Convelicdsemes ;
   protected short gxTv_SdtConvenio_base_calculo_old_Convelicdanual ;
   protected short gxTv_SdtConvenio_base_calculo_old_Convebasepromcnt1 ;
   protected short gxTv_SdtConvenio_base_calculo_old_Convebasepromcnt2 ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_SdtConvenio_base_calculo_old_Convebaseplus ;
   protected String gxTv_SdtConvenio_base_calculo_old_Convebasepromtcnt ;
   protected String sTagName ;
   protected boolean gxTv_SdtConvenio_base_calculo_old_Convelicadju ;
   protected boolean gxTv_SdtConvenio_base_calculo_old_Convelicadjuobl ;
   protected boolean gxTv_SdtConvenio_base_calculo_old_Convelicnecaut ;
   protected boolean gxTv_SdtConvenio_base_calculo_old_Convelicingmot ;
   protected boolean gxTv_SdtConvenio_base_calculo_old_Convelicmotobl ;
   protected boolean readElement ;
   protected boolean formatError ;
}

