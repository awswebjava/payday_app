package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtpct_os_fsr_pct_os_fsrItem extends GxUserType
{
   public Sdtpct_os_fsr_pct_os_fsrItem( )
   {
      this(  new ModelContext(Sdtpct_os_fsr_pct_os_fsrItem.class));
   }

   public Sdtpct_os_fsr_pct_os_fsrItem( ModelContext context )
   {
      super( context, "Sdtpct_os_fsr_pct_os_fsrItem");
   }

   public Sdtpct_os_fsr_pct_os_fsrItem( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle, context, "Sdtpct_os_fsr_pct_os_fsrItem");
   }

   public Sdtpct_os_fsr_pct_os_fsrItem( StructSdtpct_os_fsr_pct_os_fsrItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "EnConvenio") )
            {
               gxTv_Sdtpct_os_fsr_pct_os_fsrItem_Enconvenio = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "remuneracionDesde") )
            {
               gxTv_Sdtpct_os_fsr_pct_os_fsrItem_Remuneraciondesde = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "remuneracionHasta") )
            {
               gxTv_Sdtpct_os_fsr_pct_os_fsrItem_Remuneracionhasta = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "alicuota") )
            {
               gxTv_Sdtpct_os_fsr_pct_os_fsrItem_Alicuota = DecimalUtil.stringToDec( oReader.getValue()) ;
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
         sName = "pct_os_fsr.pct_os_fsrItem" ;
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
      oWriter.writeElement("EnConvenio", GXutil.booltostr( gxTv_Sdtpct_os_fsr_pct_os_fsrItem_Enconvenio));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("remuneracionDesde", GXutil.trim( GXutil.strNoRound( gxTv_Sdtpct_os_fsr_pct_os_fsrItem_Remuneraciondesde, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("remuneracionHasta", GXutil.trim( GXutil.strNoRound( gxTv_Sdtpct_os_fsr_pct_os_fsrItem_Remuneracionhasta, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("alicuota", GXutil.trim( GXutil.strNoRound( gxTv_Sdtpct_os_fsr_pct_os_fsrItem_Alicuota, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeEndElement();
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
      AddObjectProperty("EnConvenio", gxTv_Sdtpct_os_fsr_pct_os_fsrItem_Enconvenio, false, false);
      AddObjectProperty("remuneracionDesde", gxTv_Sdtpct_os_fsr_pct_os_fsrItem_Remuneraciondesde, false, false);
      AddObjectProperty("remuneracionHasta", gxTv_Sdtpct_os_fsr_pct_os_fsrItem_Remuneracionhasta, false, false);
      AddObjectProperty("alicuota", gxTv_Sdtpct_os_fsr_pct_os_fsrItem_Alicuota, false, false);
   }

   public boolean getgxTv_Sdtpct_os_fsr_pct_os_fsrItem_Enconvenio( )
   {
      return gxTv_Sdtpct_os_fsr_pct_os_fsrItem_Enconvenio ;
   }

   public void setgxTv_Sdtpct_os_fsr_pct_os_fsrItem_Enconvenio( boolean value )
   {
      gxTv_Sdtpct_os_fsr_pct_os_fsrItem_N = (byte)(0) ;
      gxTv_Sdtpct_os_fsr_pct_os_fsrItem_Enconvenio = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtpct_os_fsr_pct_os_fsrItem_Remuneraciondesde( )
   {
      return gxTv_Sdtpct_os_fsr_pct_os_fsrItem_Remuneraciondesde ;
   }

   public void setgxTv_Sdtpct_os_fsr_pct_os_fsrItem_Remuneraciondesde( java.math.BigDecimal value )
   {
      gxTv_Sdtpct_os_fsr_pct_os_fsrItem_N = (byte)(0) ;
      gxTv_Sdtpct_os_fsr_pct_os_fsrItem_Remuneraciondesde = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtpct_os_fsr_pct_os_fsrItem_Remuneracionhasta( )
   {
      return gxTv_Sdtpct_os_fsr_pct_os_fsrItem_Remuneracionhasta ;
   }

   public void setgxTv_Sdtpct_os_fsr_pct_os_fsrItem_Remuneracionhasta( java.math.BigDecimal value )
   {
      gxTv_Sdtpct_os_fsr_pct_os_fsrItem_N = (byte)(0) ;
      gxTv_Sdtpct_os_fsr_pct_os_fsrItem_Remuneracionhasta = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtpct_os_fsr_pct_os_fsrItem_Alicuota( )
   {
      return gxTv_Sdtpct_os_fsr_pct_os_fsrItem_Alicuota ;
   }

   public void setgxTv_Sdtpct_os_fsr_pct_os_fsrItem_Alicuota( java.math.BigDecimal value )
   {
      gxTv_Sdtpct_os_fsr_pct_os_fsrItem_N = (byte)(0) ;
      gxTv_Sdtpct_os_fsr_pct_os_fsrItem_Alicuota = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtpct_os_fsr_pct_os_fsrItem_N = (byte)(1) ;
      gxTv_Sdtpct_os_fsr_pct_os_fsrItem_Remuneraciondesde = DecimalUtil.ZERO ;
      gxTv_Sdtpct_os_fsr_pct_os_fsrItem_Remuneracionhasta = DecimalUtil.ZERO ;
      gxTv_Sdtpct_os_fsr_pct_os_fsrItem_Alicuota = DecimalUtil.ZERO ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtpct_os_fsr_pct_os_fsrItem_N ;
   }

   public web.Sdtpct_os_fsr_pct_os_fsrItem Clone( )
   {
      return (web.Sdtpct_os_fsr_pct_os_fsrItem)(clone()) ;
   }

   public void setStruct( web.StructSdtpct_os_fsr_pct_os_fsrItem struct )
   {
      setgxTv_Sdtpct_os_fsr_pct_os_fsrItem_Enconvenio(struct.getEnconvenio());
      setgxTv_Sdtpct_os_fsr_pct_os_fsrItem_Remuneraciondesde(struct.getRemuneraciondesde());
      setgxTv_Sdtpct_os_fsr_pct_os_fsrItem_Remuneracionhasta(struct.getRemuneracionhasta());
      setgxTv_Sdtpct_os_fsr_pct_os_fsrItem_Alicuota(struct.getAlicuota());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtpct_os_fsr_pct_os_fsrItem getStruct( )
   {
      web.StructSdtpct_os_fsr_pct_os_fsrItem struct = new web.StructSdtpct_os_fsr_pct_os_fsrItem ();
      struct.setEnconvenio(getgxTv_Sdtpct_os_fsr_pct_os_fsrItem_Enconvenio());
      struct.setRemuneraciondesde(getgxTv_Sdtpct_os_fsr_pct_os_fsrItem_Remuneraciondesde());
      struct.setRemuneracionhasta(getgxTv_Sdtpct_os_fsr_pct_os_fsrItem_Remuneracionhasta());
      struct.setAlicuota(getgxTv_Sdtpct_os_fsr_pct_os_fsrItem_Alicuota());
      return struct ;
   }

   protected byte gxTv_Sdtpct_os_fsr_pct_os_fsrItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_Sdtpct_os_fsr_pct_os_fsrItem_Remuneraciondesde ;
   protected java.math.BigDecimal gxTv_Sdtpct_os_fsr_pct_os_fsrItem_Remuneracionhasta ;
   protected java.math.BigDecimal gxTv_Sdtpct_os_fsr_pct_os_fsrItem_Alicuota ;
   protected String sTagName ;
   protected boolean gxTv_Sdtpct_os_fsr_pct_os_fsrItem_Enconvenio ;
   protected boolean readElement ;
   protected boolean formatError ;
}

